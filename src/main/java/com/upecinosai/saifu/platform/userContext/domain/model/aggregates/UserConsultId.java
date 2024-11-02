package com.upecinosai.saifu.platform.userContext.domain.model.aggregates;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class UserConsultId implements Serializable {
    @Column(name = "ID_USUARIO")
    private Long userId;

    @Column(name = "ID_CONSULTA")
    private Long consultId;

    // Getters, setters, equals, and hashCode
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getConsultId() {
        return consultId;
    }

    public void setConsultId(Long consultId) {
        this.consultId = consultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserConsultId that = (UserConsultId) o;
        return userId.equals(that.userId) && consultId.equals(that.consultId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, consultId);
    }
}