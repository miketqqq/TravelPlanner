package com.mike.dailyjourney;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mike.plan.PlanModel;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
public class DailyJourneyModel {

    // for each day in a plan
    @Id @GeneratedValue()
    private Long id;

    @ManyToOne(targetEntity = PlanModel.class, fetch=FetchType.LAZY)
    @JoinColumn(name="plan_id")  //nullable = false, updatable=false,insertable=false
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PlanModel plan;

    @Column(nullable = false)
    private int dayCount;

    @Column(nullable = false)
    private LocalDate date;

    public DailyJourneyModel() {
    }

    public DailyJourneyModel(PlanModel plan, int dayCount, LocalDate date) {
        this.plan = plan;
        this.dayCount = dayCount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPlan() {
        return plan.getId();
    }

    public void setPlan(PlanModel plan) {
        this.plan = plan;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
