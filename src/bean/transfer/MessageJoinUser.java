package bean.transfer;

import java.sql.Timestamp;

public class MessageJoinUser {
    private String msgid;
    private String uid;
    private String name;
    private String content;
    private Timestamp time;
    public MessageJoinUser(String msgid, String uid, String name, String content, Timestamp time) {
        super();
        this.msgid = msgid;
        this.uid = uid;
        this.name = name;
        this.content = content;
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageJoinUser{" +
                "msgid='" + msgid + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public MessageJoinUser() {

    }

    public String getMsgid() {
        return msgid;
    }
    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
}

