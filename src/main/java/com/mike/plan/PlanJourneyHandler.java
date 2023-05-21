package com.mike.plan;

import com.mike.dailyjourney.DailyJourneyModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanJourneyHandler {

    public static ArrayList<DailyJourneyModel> createJourneys(PlanModel plan) {
        int duration = plan.getDuration();
        LocalDate endDate = plan.getEndDate();
        LocalDate startDate = plan.getStartDate();
        int i = 1;

        ArrayList<DailyJourneyModel> journeys = new ArrayList<>(duration);
        for (LocalDate date = startDate; !date.isAfter(endDate); date=date.plusDays(1)){
            DailyJourneyModel dailyJourney = new DailyJourneyModel(plan, i, date);
            journeys.add(dailyJourney);
            i++;
        }
        return journeys;
    }
}
