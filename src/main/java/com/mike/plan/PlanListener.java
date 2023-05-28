package com.mike.plan;

import com.mike.numberofday.NumberOfDay;
import com.mike.numberofday.NumberOfDayRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.logging.Logger;

@Component
public class PlanListener {

    private static final Logger logger = Logger.getLogger("PlanListener");

    private static NumberOfDayRepository numberOfDayRepository;

    @Autowired
    public void setNumberOfDayRepository(NumberOfDayRepository numberOfDayRepository) {
        PlanListener.numberOfDayRepository = numberOfDayRepository;
    }

    @PrePersist @PreUpdate
    public void prePersist(Plan plan) {
        plan.setDuration();
    }

    @PostPersist
    public void postPersist(Plan plan) {
        ArrayList<NumberOfDay> newNumberOfDays = PlanDayHandler.createNumberOfDays(plan);
        logger.info(String.valueOf(newNumberOfDays.size()) + " new NumberOfDays are created @PostPersist");
        PlanListener.numberOfDayRepository.saveAll(newNumberOfDays);
    }

}
