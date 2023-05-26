package com.mike.plan;

import com.mike.dailyjourney.DailyJourney;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanJourneyHandler {

    public static ArrayList<DailyJourney> createJourneys(Plan plan) {
        int duration = plan.getDuration();
        LocalDate endDate = plan.getEndDate();
        LocalDate startDate = plan.getStartDate();
        int dayCount = 1;

        ArrayList<DailyJourney> journeys = new ArrayList<>(duration);
        for (LocalDate date = startDate; !date.isAfter(endDate); date=date.plusDays(1)){
            DailyJourney dailyJourney = new DailyJourney(plan, dayCount, date);
            journeys.add(dailyJourney);
            dayCount++;
        }
        return journeys;
    }
}
