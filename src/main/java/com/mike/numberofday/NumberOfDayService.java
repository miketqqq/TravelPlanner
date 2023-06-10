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


    public List<NumberOfDay> getAllDays(){
        List<NumberOfDay> days = new ArrayList<>();
        numberOfDayRepository.findAll().forEach(days::add);
        return days;
    }

    public List<NumberOfDay> getAllDaysByPlanId(Long plan_id){
        List<NumberOfDay> days = new ArrayList<>();
        numberOfDayRepository.findAllByPlanId(plan_id).forEach(days::add);
        return days;
    }

    public NumberOfDay getDay(Long plan_id, int dayNumber){
        return numberOfDayRepository.findByPlanIdAndDayNumber(plan_id, dayNumber);
    }






}
