package bean.entity;

public class User {
    private String uid;
    private String name;
    private String password;
    private String email;
    public User(String uid, String name, String password, String email) {
        super();
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public User() {}
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
