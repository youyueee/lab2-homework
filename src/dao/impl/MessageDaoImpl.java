package dao.impl;

import bean.entity.Message;
import bean.transfer.MessageJoinUser;
import dao.MessageDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import utils.JDBCConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    private static final Log log = LogFactory.getLog(MessageDaoImpl.class);


    @Override
    public String create(Message msg) {
        try(Connection conn = JDBCConnector.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("insert into message values(?,?,?,?)");
            pstmt.setString(1, msg.getMsgid());
            pstmt.setString(2, msg.getUid());
            pstmt.setString(3, msg.getContent());
            pstmt.setTimestamp(4, msg.getTime());
            pstmt.executeUpdate();
            return msg.getMsgid();
        } catch (SQLException e) {
            log.warn("消息创建失败");
        }
        return null;
    }

    @Override
    public Message read(String id) {
        return null;
    }

    @Override
    public void update(Message transientObject) {

    }

    @Override
    public void delete(Message persistentObject) {

    }

    @Override
    public List<MessageJoinUser> limit(int start, int size) {
        List<MessageJoinUser> list = new ArrayList<MessageJoinUser>();
        try(Connection conn = JDBCConnector.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("select msgid,message.uid,name,content,time from message, user where message.uid = user.uid order by time desc limit ? , ?");
            pstmt.setInt(1, start);
            pstmt.setInt(2, size);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                list.add(new MessageJoinUser(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getTimestamp(5)));
            }
        } catch (SQLException e) {
            log.warn("查询消息失败");
        }
        return list;
    }
    @Override
    public List<MessageJoinUser> search(String keyword){
        List<MessageJoinUser> MsList = new ArrayList<>();
        try {
            Connection con = JDBCConnector.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM message WHERE content LIKE CONCAT('%', ?, '%')");
            ps.setString(1, keyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MessageJoinUser ms = new  MessageJoinUser();
                ms.setMsgid(rs.getString("msgid"));
                ms.setUid(rs.getString("uid"));
                ms.setContent(rs.getString("content"));
                ms.setTime(rs.getTimestamp("time"));
                MsList.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MsList;
    }

}

