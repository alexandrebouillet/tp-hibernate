package fr.epsi.model;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin extends User implements Serializable {


    @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
    @Cascade({CascadeType.ALL, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<CreditCard> creditCard;

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }
}

