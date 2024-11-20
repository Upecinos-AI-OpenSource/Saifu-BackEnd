package com.upecinosai.saifu.platform.profile.domain.model.aggregates;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateFamilyCommand;
import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import com.upecinosai.saifu.platform.profile.domain.model.valueObjects.PhoneNumber;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Family extends AbstractAggregateRoot<Family> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FAMILY_ID;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Column(nullable=false)
    private String FAMILY_NAME;

    @Column(nullable=false)
    private int MEMBERS;

    @Column(nullable=false)
    private String DIRECTION;

    @Embedded
    @Column(nullable=false)
    private PhoneNumber PHONE_NUMBER;

    protected Family() {}

    public Family(CreateFamilyCommand command, User user) {
        this.user = user;
        this.FAMILY_NAME = command.familyName();
        this.MEMBERS = command.members();
        this.DIRECTION = command.direction();
        this.PHONE_NUMBER = command.phoneNumber();
    }

    public Long getFAMILY_ID() {
        return FAMILY_ID;
    }

    public void setFAMILY_ID(Long FAMILY_ID) {
        this.FAMILY_ID = FAMILY_ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFAMILY_NAME() {
        return FAMILY_NAME;
    }

    public void setFAMILY_NAME(String FAMILY_NAME) {
        this.FAMILY_NAME = FAMILY_NAME;
    }

    public int getMEMBERS() {
        return MEMBERS;
    }

    public void setMEMBERS(int MEMBERS) {
        this.MEMBERS = MEMBERS;
    }

    public String getDIRECTION() {
        return DIRECTION;
    }

    public void setDIRECTION(String DIRECTION) {
        this.DIRECTION = DIRECTION;
    }

    public PhoneNumber getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(PhoneNumber PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }
}
