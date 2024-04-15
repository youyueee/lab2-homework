//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bean.entity;

import java.sql.Timestamp;

public class Message {
    private String msgid;
    private String uid;
    private String content;
    private Timestamp time;

    public Message(String msgid, String uid, String content, Timestamp time) {
        this.msgid = msgid;
        this.uid = uid;
        this.content = content;
        this.time = time;
    }

    public Message() {

    }

    public String getMsgid() {
        return this.msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
