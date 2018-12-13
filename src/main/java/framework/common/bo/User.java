package framework.common.bo;

public class User {
    private String username;
    private String pass;

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public User(){
        this.username = "new_account_2018@bk.ru";
        this.pass = "password2018";
    }
    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
