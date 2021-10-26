package epam.java.chapter6.task3.client;




import epam.java.chapter6.task3.client.logic.ClientLogic;
import epam.java.chapter6.task3.client.logic.ConsoleInputLogic;
import epam.java.chapter6.task3.server.entity.UserType;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;


public class Client {
    private static final int serverPort = 8000;
    private static final String localhost = "127.0.0.1";
    private static boolean isAuthorized = false;

    private static void sendRequest(DataOutputStream out, String request){
        try {
            out.writeUTF(request);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] getResponse(DataInputStream in){
        String[] responseArgs = null;
        String response;

        try {
            response = in.readUTF();
            responseArgs = response.split("\\|");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseArgs;
    }

    public static void main(String[] args) {
        Socket socket = null;
        try {
            try {
                System.out.println("Welcome to Client side\n" +
                        "Connecting to the server\n\t" +
                        "(IP address " + localhost +
                        ", port " + serverPort + ")");

                InetAddress ipAddress;
                ipAddress = InetAddress.getByName(localhost);
                socket = new Socket(ipAddress, serverPort);
                System.out.println("The connection is established.");
                System.out.println("\tLocalPort = " + socket.getLocalPort() + "\n\tInetAddress.HostAddress = " +
                                socket.getInetAddress().getHostAddress() + "\n\tReceiveBufferSize (SO_RCVBUF) = "
                                + socket.getReceiveBufferSize());


                InputStream  sin  = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();

                DataInputStream  in ;
                DataOutputStream out;
                in  = new DataInputStream (sin );
                out = new DataOutputStream(sout);

                String line = null;
                String responseArgs[] = null;

                ClientLogic clientLogic = new ClientLogic();
                ConsoleInputLogic consoleInputLogic = new ConsoleInputLogic();

                int menuItem;
                int maxItems = 0;
                StringBuilder mainMenu;

                mainMenu = new StringBuilder("Главное меню\n");

                while (true) {

                    while (!isAuthorized){
                        line = clientLogic.getRequest(clientLogic.inputAuthorizationData(consoleInputLogic));

                        sendRequest(out, line);

                        responseArgs = getResponse(in);

                        if (responseArgs[0].equals("1")){
                            isAuthorized = true;

                            if (UserType.valueOf(responseArgs[2].toUpperCase()) == UserType.USER){
                                mainMenu.append("0 - Выход\n" +
                                        "1 - Поиск дела\n" +
                                        "2 - Отображение списка дел\n");
                                maxItems = 2;
                            }else{
                                mainMenu.append("0 - Выход\n" +
                                        "1 - Поиск дела\n" +
                                        "2 - Отображение списка дел\n" +
                                        "3 - Добавление дела\n" +
                                        "4 - Изменение дела\n");
                                maxItems = 5;
                            }
                        }

                        System.out.println(responseArgs[1]);
                    }

                    menuItem = consoleInputLogic.getIntDataFromConsole(mainMenu.toString(), 0, maxItems);

                    switch (menuItem){
                        case 0:{
                            line = "exit";
                            break;
                        }
                        case 1:{
                            line = clientLogic.getRequest(clientLogic.inputSearchParams(consoleInputLogic));
                            break;
                        }
                        case 2:{
                            line = clientLogic.getRequest(new String[]{"show_files"});
                            break;
                        }
                        case 3:{
                            line = clientLogic.getRequest(clientLogic.inputAddFileData(consoleInputLogic));
                            break;
                        }
                        case 4:{
                            line = clientLogic.getRequest(clientLogic.inputEditFileParams(consoleInputLogic));
                            break;
                        }
                    }

                    sendRequest(out, line);

                    if (menuItem == 0){
                        break;
                    }

                    responseArgs = getResponse(in);

                    System.out.println(Arrays.toString(responseArgs));

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } finally {
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
