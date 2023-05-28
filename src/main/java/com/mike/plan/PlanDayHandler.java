package com.mike.plan;

import com.mike.numberofday.NumberOfDay;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanDayHandler {

    public static ArrayList<NumberOfDay> createNumberOfDays(Plan plan) {
        int duration = plan.getDuration();
        LocalDate endDate = plan.getEndDate();
        LocalDate startDate = plan.getStartDate();
        int day = 1;

        ArrayList<NumberOfDay> numberOfDays = new ArrayList<>(duration);
        for (LocalDate date=startDate; !date.isAfter(endDate); date=date.plusDays(1)){
            NumberOfDay numberOfDay = new NumberOfDay(plan, date, day);
            numberOfDays.add(numberOfDay);
            day++;
        }
        return numberOfDays;
    }

//    public static void updateJourneys(Plan newPlan, LocalDate oldStartDate, LocalDate oldEndDate) {
//        LocalDate newStartDate = newPlan.getStartDate();
//        LocalDate newEndDate = newPlan.getEndDate();
//
//    }
}
