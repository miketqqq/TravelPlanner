package com.mike.plan;

import com.mike.dailyjourney.DailyJourney;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity @EntityListeners(PlanListener.class)
public class Plan {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    //auto generated when plan is created. to be change when start/end date changed.
    @Column(nullable = false)
    private int duration;

    @OneToMany(mappedBy = "plan")
    private List<DailyJourney> DailyJourneyList;


    public Plan() {}

    public Plan(String name, String country, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString(){
        return "Plan[" + "name=" + this.name + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration() {
        this.duration = (int) DAYS.between(this.startDate, this.endDate) + 1;
    }
}
