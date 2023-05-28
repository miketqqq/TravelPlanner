package com.mike.view;

import com.mike.dailyjourney.DailyJourney;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalTime;

@Entity
public class View {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity=DailyJourney.class, fetch=FetchType.LAZY)
    @JoinColumn(name="dailyJourney_id", nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private DailyJourney dailyJourney;

    @Column
    private String category;  //to be foreign key

    @Column(nullable = false)
    private String viewpoint;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private String remarks;

    public Long getId(){ return id;}

    public void setId(Long id){ this.id = id;}

    public Long getDailyJourney() {
        return dailyJourney.getId();
    }

    public void setDailyJourney(DailyJourney dailyJourney) {
        this.dailyJourney = dailyJourney;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getViewpoint() {
        return viewpoint;
    }

    public void setViewpoint(String viewpoint) {
        this.viewpoint = viewpoint;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime start_time) {
        this.startTime = start_time;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime end_time) {
        this.endTime = end_time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}
