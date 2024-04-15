package service;



import bean.entity.Message;
import bean.transfer.MessageJoinUser;

import java.util.List;

public interface MessageService {
    boolean post(Message msg); // 判断是否创建成功
    List<MessageJoinUser> getMessages(int pageSize, int pageIndex);

    List<MessageJoinUser> search(String keyword);
}
