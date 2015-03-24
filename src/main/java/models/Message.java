package models;


public class Message {
    private String recipient;
    private String subject;
    private String message;

    public Message() {
        this.recipient = null;
        this.subject = null;
        this.message = null;
    }

    public Message(String recipient, String subject, String message) {
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() { return recipient + ' '  + subject + ' ' + message + ' ';
    }
}
