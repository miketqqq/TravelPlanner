package com.mike.view;

import com.mike.dailyjourney.DailyJourney;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

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

    //private invoiceModel invoice_id;  //foreign key

    @Column
    private LocalDate startTime;

    @Column
    private LocalDate endTime;

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

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate start_time) {
        this.startTime = start_time;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate end_time) {
        this.endTime = end_time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}
