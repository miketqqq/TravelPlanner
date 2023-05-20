package com.mike.dailyjourney;

import com.mike.plan.PlanModel;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
public class DailyJourneyModel {

    // for each day in a plan
    @Id
    private Long id;

    @ManyToOne(targetEntity = PlanModel.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PlanModel planModel;

    //auto generated when plan is created.
    @Column(nullable = false)
    private int day_count;

    @Column(nullable = false)
    private Date date;

    public DailyJourneyModel() {
    }


    public int getDay_count() {
        return day_count;
    }

    public void setDay_count(int day_count) {
        this.day_count = day_count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
