package service.impl;

import bean.entity.Message;
import bean.transfer.MessageJoinUser;
import dao.MessageDao;
import dao.impl.MessageDaoImpl;
import service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    private MessageDao md = new MessageDaoImpl();

    @Override
    public boolean post(Message msg) {
        if(md.create(msg) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<MessageJoinUser> getMessages(int pageSize, int pageIndex) {
        int start = pageSize * (pageIndex - 1);
        return md.limit(start, pageSize);
    }


    @Override
    public List<MessageJoinUser> search(String keyword) {
        return md.search("%"+keyword+"%");
    }

}