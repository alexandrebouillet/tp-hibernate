package fr.epsi.dao;

import fr.epsi.model.Message;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.IntStream;

public class MessageDao extends AbstractDao<Message> {

   public List<Message> findMessageByUsername(String username) {

        return this.execute((session) -> {
            Query query = session.createQuery("FROM Message m WHERE m.content LIKE CONCAT('%',?1,'%')");
            query.setParameter(1, username);
            List messages = query.getResultList();
            return messages;
        });
    }

}
