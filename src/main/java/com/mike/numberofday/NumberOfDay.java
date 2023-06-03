package com.mike.numberofday;

import com.mike.dailyjourney.DailyJourney;
import com.mike.plan.Plan;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity @Table(name="number_of_day")
public class NumberOfDay {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //if nullable=false, plan must be saved before journey is saved.
    //such that the plan.id exist for journey to reference. or use cascade.ALL in plan
    @ManyToOne(targetEntity=Plan.class, fetch=FetchType.LAZY)
    @JoinColumn(name="plan_id")  //updatable=false
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Plan plan;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int dayNumber;

    @OneToOne(targetEntity=DailyJourney.class)
    @JoinColumn(name="daily_journey_id")
    @Cascade(CascadeType.ALL)
    private DailyJourney dailyJourney;

    public NumberOfDay() {}

    public NumberOfDay(Plan plan, LocalDate date, int dayNumber) {
        this.plan = plan;
        this.date = date;
        this.dayNumber = dayNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Long getPlan() {
        return plan.getId();
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public DailyJourney getDailyJourney() {
            return dailyJourney;
    }

    public void setDailyJourney(DailyJourney dailyJourney) {
        this.dailyJourney = dailyJourney;
    }
}
