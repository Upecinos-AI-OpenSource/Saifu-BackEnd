package com.upecinosai.saifu.platform.userContext.domain.model.aggregates;


import javax.persistence.*;

@Entity
@Table(name = "user_consult")
public class UserConsult {
    @EmbeddedId
    private UserConsultId id;

    // Getters and setters
    public UserConsultId getId() {return id;}

    public void setId(UserConsultId id) {this.id = id;}

}