package com.mike.dailyjourney;

import com.mike.numberofday.NumberOfDay;
import com.mike.view.View;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


import java.util.List;

@Entity
public class DailyJourney {

    // for each day in a plan
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity=NumberOfDay.class)
    @JoinColumn(name="number_of_day_id", insertable=false, updatable=false)
    private NumberOfDay numberOfDay;

    @Column(name="number_of_day_id", nullable=false)
    private Long numberOfDayID;

    @OneToMany(mappedBy="dailyJourney", fetch=FetchType.EAGER, orphanRemoval=true)
    @Cascade(CascadeType.ALL)
    private List<View> View;


    public DailyJourney() {}

    public DailyJourney(NumberOfDay numberOfDay) {
        this.numberOfDay = numberOfDay;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberOfDayID() {
        return numberOfDayID;
    }

    public void setnumberOfDayID(Long numberOfDayID) {
        this.numberOfDayID = numberOfDayID;
    }

    public List<View> getView() {
        return View;
    }

    public void setView(List<View> view) {
        View = view;
    }

}
