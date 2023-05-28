package com.mike.numberofday;


import com.mike.plan.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberOfDayService {

    @Autowired
    private NumberOfDayRepository numberOfDayRepository;

    public NumberOfDay getDay(Long plan_id, int dayNumber){
        return numberOfDayRepository.findByPlanIdAndDayNumber(plan_id, dayNumber);
    }

}
