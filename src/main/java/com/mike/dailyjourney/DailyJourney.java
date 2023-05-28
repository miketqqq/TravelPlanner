package com.mike.dailyjourney;

import com.mike.numberofday.NumberOfDay;
import com.mike.view.View;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class DailyJourney {

    // for each day in a plan
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //if nullable=false, plan must be saved before journey is saved.
    //such that the plan.id exist for journey to reference. or use cascade.ALL in plan
    @OneToOne(targetEntity=NumberOfDay.class, mappedBy="dailyJourney")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private NumberOfDay numberOfDay;

    @OneToMany(mappedBy="dailyJourney")
    @Cascade(CascadeType.DELETE)
    private List<View> View;


    public DailyJourney() {
    }

    public DailyJourney(NumberOfDay numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDayCount() {
        return numberOfDay.getDayNumber();
    }

    public void setDayCount(NumberOfDay numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public List<View> getView() {
        return View;
    }

    public void setView(List<View> view) {
        View = view;
    }

}
