package epam.java.chapter6.task3.server;

import epam.java.chapter6.task3.server.config.Config;
import epam.java.chapter6.task3.server.controller.ControllerClass;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 8000;

    public static void main(String[] args) {
        if (args.length > 0){
            Config.setRootPath(args[0]);
        }

        ServerSocket serverSocket = null;

        try {
            try {
                serverSocket = new ServerSocket(port);

                System.out.println("Сервер запущен!\n\n");

                while(true){
                    Socket socket;

                    socket = serverSocket.accept();
                    System.out.println("Клиент подключился");

                    runConnection(socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                if (serverSocket != null){
                    serverSocket.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void runConnection(Socket socket){
        try {

            DataInputStream dis;
            DataOutputStream dos;

            String line;
            String requestArgs[];
            ServerResponse serverResponse;
            ControllerClass controllerClass;

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            controllerClass = ControllerClass.getInstance();

            while(true){
                line = dis.readUTF();
                System.out.println("Сообщение от клиента: " + line);

                requestArgs = line.split("\\|");

                if (requestArgs[0].equals("exit")){
                    socket.close();
                    System.out.println("Закрытие соединения между клиентом и сервером");
                    break;
                }

                serverResponse = controllerClass.execute(requestArgs[0], requestArgs);

                System.out.print("Отправка ответа клиенту: ");
                System.out.println(serverResponse.getOperationCode() + "|" + serverResponse.getMessage());

                dos.writeUTF(serverResponse.getOperationCode() + "|" + serverResponse.getMessage());
                dos.flush();

                //System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
