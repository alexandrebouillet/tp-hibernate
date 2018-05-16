package fr.epsi.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "channel")
public class Channel implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(mappedBy = "channels")
    private List<User> users;

    @OneToMany(mappedBy = "channel", fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL})
    private List<Message> messages;

    private String name;

    private boolean isPrivate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
