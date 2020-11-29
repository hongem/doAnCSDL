package democsdl.demo.dto;

public class MessageResponse {
    private int status;
    private String message;

    public MessageResponse(int status, String message) {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
