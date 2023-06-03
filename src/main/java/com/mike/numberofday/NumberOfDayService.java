package com.mike.numberofday;


import com.mike.dailyjourney.DailyJourney;
import com.mike.dailyjourney.DailyJourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberOfDayService {

    @Autowired
    private NumberOfDayRepository numberOfDayRepository;

    @Autowired
    private DailyJourneyRepository dailyJourneyRepository;


    public List<NumberOfDay> getAllDay(Long plan_id){
        List<NumberOfDay> days = new ArrayList<>();
        numberOfDayRepository.findAllByPlanId(plan_id).forEach(days::add);
        return days;
    }

    public NumberOfDay getDay(Long plan_id, int dayNumber){
        return numberOfDayRepository.findByPlanIdAndDayNumber(plan_id, dayNumber);
    }


    public NumberOfDay swapDay(Long plan_id, int dayNumber, int otherDayNumber){
        NumberOfDay thisDay = numberOfDayRepository.findByPlanIdAndDayNumber(plan_id, dayNumber);
        NumberOfDay otherDay = numberOfDayRepository.findByPlanIdAndDayNumber(plan_id, otherDayNumber);

        DailyJourney thisJourney = thisDay.getDailyJourney();
        DailyJourney otherJourney = otherDay.getDailyJourney();

        thisDay.setDailyJourney(otherJourney);
        otherDay.setDailyJourney(thisJourney);
        numberOfDayRepository.save(thisDay);
        numberOfDayRepository.save(otherDay);

        return thisDay;
    }



}
