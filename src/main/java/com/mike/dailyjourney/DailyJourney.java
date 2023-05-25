package com.mike.dailyjourney;

import com.mike.plan.Plan;
import com.mike.view.View;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
public class DailyJourney {

    // for each day in a plan
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //if nullable=false, plan must be saved before journey is saved.
    //such that the plan.id exist for journey to reference. or use cascade.ALL in plan
    @ManyToOne(targetEntity=Plan.class, fetch=FetchType.LAZY)
    @JoinColumn(name="plan_id")  //updatable=false
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Plan plan;

    @Column(nullable = false)
    private int dayCount;

    @Column(nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "dailyJourney")
    private List<View> View;

    public DailyJourney() {
    }

    public DailyJourney(Plan plan, int dayCount, LocalDate date) {
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

    public void setPlan(Plan plan) {
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
