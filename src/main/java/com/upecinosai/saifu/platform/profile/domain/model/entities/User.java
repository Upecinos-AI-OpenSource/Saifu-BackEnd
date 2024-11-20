package com.upecinosai.saifu.platform.profile.domain.model.entities;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreateUserCommand;
import com.upecinosai.saifu.platform.profile.domain.model.valueObjects.State;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter
    private Long USERID;

    @Getter
    @Column(nullable = false)
    private String USERNAME;

    @Getter
    @Column(nullable = false)
    private String PASSWORD;

    @Getter
    @Column(nullable = false)
    private String EMAIL;

    @Getter
    @Column(nullable = false)
    private String USER_TYPE;

    @Enumerated(EnumType.STRING)
    @Getter
    @Column(nullable = false)
    private State STATE;

    @Getter
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date CREATED_DATE;

    protected User() {}

    public User (CreateUserCommand command) {
        this.USERNAME = command.username();
        this.PASSWORD = command.password();
        this.EMAIL = command.email();
        this.USER_TYPE = command.user_type();
        this.STATE = command.state();
    }

    @PrePersist
    protected void onCreate() {
        if (CREATED_DATE == null) {
            CREATED_DATE = new Date();
        }
    }

    public Long getUSERID() {
        return USERID;
    }

    public void setUSERID(Long USERID) {
        this.USERID = USERID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(String USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public State getSTATE() {
        return STATE;
    }

    public void setSTATE(State STATE) {
        this.STATE = STATE;
    }

    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }
}