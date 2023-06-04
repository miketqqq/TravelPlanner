package com.mike.plan;

import com.mike.dailyjourney.DailyJourney;
import com.mike.numberofday.NumberOfDay;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanDayHandler {

    public static ArrayList<NumberOfDay> createNumberOfDays(Plan plan) {
        int duration = plan.getDuration();
        LocalDate startDate = plan.getStartDate();
        LocalDate endDate = plan.getEndDate();
        int day = 1;

        ArrayList<NumberOfDay> numberOfDays = new ArrayList<>(duration);
        for (LocalDate date=startDate; !date.isAfter(endDate); date=date.plusDays(1)){
            NumberOfDay numberOfDay = new NumberOfDay(plan, day);
            numberOfDay.setDailyJourney(new DailyJourney());
            numberOfDays.add(numberOfDay);
            day++;
        }
        return numberOfDays;
    }

//    public static ArrayList<NumberOfDay> updateJourneys(Plan plan, LocalDate oldStartDate, LocalDate oldEndDate) {
//        LocalDate newStartDate = newPlan.getStartDate();
//        LocalDate newEndDate = newPlan.getEndDate();
        //if !oldStartDate.equals(newStartDate) || !oldEndDate.equals(newEndDate)
        //ArrayList<NumberOfDay> numberOfDays = new ArrayList<>(duration);
        //query all NumberOfDay under certain plan_id, sorted by dayNumber
        //
        //for (NumberOfDay day: NumberOfDays)
        //if day.dayNumber > plan.duration, day.delete
        //else day.date = plan.startdate + day.dayNumber - 1
        //numberOfDays.add(day)
        //return numberOfDays

//
//    }
}
