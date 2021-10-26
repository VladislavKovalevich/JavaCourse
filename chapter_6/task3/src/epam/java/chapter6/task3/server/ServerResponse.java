package epam.java.chapter6.task3.server;

public class ServerResponse {
    private int operationCode;
    private String message;

    public ServerResponse(){

    }

    public ServerResponse(int operationCode, String message) {
        this.operationCode = operationCode;
        this.message = message;
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
