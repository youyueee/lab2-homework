package dao;

import bean.entity.Message;
import bean.transfer.MessageJoinUser;

import java.util.List;

public interface MessageDao extends Dao<Message, String>{
    List<MessageJoinUser> limit(int start, int size);
    List<MessageJoinUser> search(String keyword);
}
