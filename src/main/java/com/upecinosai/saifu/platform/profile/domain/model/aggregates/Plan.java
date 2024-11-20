package com.upecinosai.saifu.platform.profile.domain.model.aggregates;

import com.upecinosai.saifu.platform.profile.domain.model.commands.CreatePlanCommand;
import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Plan extends AbstractAggregateRoot<Plan> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PLANID;

    @ManyToOne
    @JoinColumn(name="USERID", nullable=false)
    private User user;

    @Column(nullable = false)
    private String PLAN_NAME;

    @Lob
    @Column(nullable = false)
    private String DESCRIPTION;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal COST;

    @Column(nullable = false)
    private int MONTH_DURATION;

    protected Plan() {}

    public Plan(CreatePlanCommand command, User user) {
        this.user = user;
        this.PLAN_NAME = command.planName();
        this.DESCRIPTION = command.description();
        this.COST = command.cost();
        this.MONTH_DURATION = command.monthDuration();
    }

    public Long getPLANID() {
        return PLANID;
    }

    public void setPLANID(Long PLANID) {
        this.PLANID = PLANID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPLAN_NAME() {
        return PLAN_NAME;
    }

    public void setPLAN_NAME(String PLAN_NAME) {
        this.PLAN_NAME = PLAN_NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public BigDecimal getCOST() {
        return COST;
    }

    public void setCOST(BigDecimal COST) {
        this.COST = COST;
    }

    public int getMONTH_DURATION() {
        return MONTH_DURATION;
    }

    public void setMONTH_DURATION(int MONTH_DURATION) {
        this.MONTH_DURATION = MONTH_DURATION;
    }
}
