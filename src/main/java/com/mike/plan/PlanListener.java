package com.mike.plan;

import com.mike.dailyjourney.DailyJourney;
import com.mike.dailyjourney.DailyJourneyRepository;
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
        logger.info(String.valueOf(newJourneys.size()) + " new journeys are created @PostPersist");
        PlanListener.dailyJourneyRepository.saveAll(newJourneys);
    }

}
