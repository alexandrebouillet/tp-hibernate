package fr.epsi.dao;

import fr.epsi.model.Channel;
import fr.epsi.model.Message;
import fr.epsi.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

public class ChannelDaoTest {

    @Test
    public void insertChannel() {
        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");
        user.setEmail("test@gmail.com");


        Channel channel1 = new Channel();
        channel1.setName("Channel1");
        channel1.setPrivate(true);

        Channel channel2 = new Channel();
        channel2.setName("Channel2");
        channel2.setPrivate(false);

        user.setChannels(Arrays.asList(channel1, channel2));

        long id = new UserDao().save(user);
        User u = new UserDao().get(id);

        Assert.assertEquals(2, u.getChannels().size());
    }

    @Test
    public void insertMessageInChannel(){
        User user = new User();
        user.setFirstname("Alex");
        user.setLastname("Bouillet");
        user.setEmail("test2@gmail.com");


        Channel channel = new Channel();
        channel.setName("Channel1");
        channel.setPrivate(true);

        Message message1 = new Message();
        message1.setContent("Message1");
        message1.setChannel(channel);
        message1.setUser(user);

        Message message2 = new Message();
        message2.setContent("Message2");
        message2.setChannel(channel);
        message2.setUser(user);

        channel.setMessages(Arrays.asList(message1, message2));


        long id = new ChannelDao().save(channel);
        Channel c = new ChannelDao().get(id);

        Assert.assertEquals(2, c.getMessages().size());
    }

    @Test
    public void searchMessageByUsername() {
        User user = new User();
        user.setFirstname("Alex");
        user.setLastname("Bouillet");
        user.setEmail("test3@gmail.com");


        Channel channel = new Channel();
        channel.setName("Channel1");
        channel.setPrivate(true);

        Message message1 = new Message();
        message1.setContent("Message1: @Alex");
        message1.setChannel(channel);
        message1.setUser(user);

        Message message2 = new Message();
        message2.setContent("Message2: @ici");
        message2.setChannel(channel);
        message2.setUser(user);

        channel.setMessages(Arrays.asList(message1, message2));


        new ChannelDao().save(channel);

        long id = new ChannelDao().save(channel);
        Channel c = new ChannelDao().get(id);

        Assert.assertEquals(1, new MessageDao().findMessageByUsername("Alex").size());

    }

}
