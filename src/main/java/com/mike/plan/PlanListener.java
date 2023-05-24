package com.mike.plan;

import com.mike.dailyjourney.DailyJourney;
import com.mike.dailyjourney.DailyJourneyRepository;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PlanListener {

    private static DailyJourneyRepository dailyJourneyRepository;

    @Autowired
    public void setDailyJourneyRepository(DailyJourneyRepository dailyJourneyRepository) {
        PlanListener.dailyJourneyRepository = dailyJourneyRepository;
    }

    @PrePersist @PreUpdate
    public void prePersist(Plan plan) {
        plan.setDuration();
    }

    @PostPersist
    public void postPersist(Plan plan) {
        ArrayList<DailyJourney> newJourneys = PlanJourneyHandler.createJourneys(plan);
        PlanListener.dailyJourneyRepository.saveAll(newJourneys);
    }

}
