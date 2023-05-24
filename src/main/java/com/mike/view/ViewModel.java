package com.mike.view;

import com.mike.dailyjourney.DailyJourney;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

public class ViewModel {

    @Id
    private Long id;

    @ManyToOne(targetEntity = DailyJourney.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DailyJourney journey_id;

    @Column
    private String  category;  //to be foreign key

    //private invoiceModel invoice_id;  //foreign key

    @Column
    private Date start_time;

    @Column
    private Date end_time;

    @Column
    private String remarks;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
