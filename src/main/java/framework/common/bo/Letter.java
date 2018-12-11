package framework.common.bo;

public class Letter {
    private String addressee;
    private String subject;
    private String body;

    public Letter(String addressee, String subject, String body) {
        this.addressee = addressee;
        this.subject = subject;
        this.body = body;
    }

    public String getAddressee() {
        return addressee;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "addressee='" + addressee + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
