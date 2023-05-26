package com.mike.dailyjourney;

import com.mike.plan.Plan;
import com.mike.plan.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DailyJourneyService {

    @Autowired
    private DailyJourneyRepository dailyJourneyRepository;

    @Autowired
    private PlanRepository planRepository;

    public List<DailyJourney> getAllDailyJourneys(){
        List<DailyJourney> dailyJourneyList = new ArrayList<>();
        dailyJourneyRepository.findAll().forEach(dailyJourneyList::add);
        return dailyJourneyList;
    }

    public List<DailyJourney> getDailyJourneysByDate(LocalDate date){
        List<DailyJourney> dailyJourneyList = new ArrayList<>();
        dailyJourneyRepository.findByDate(date).forEach(dailyJourneyList::add);
        return dailyJourneyList;
    }

    public List<DailyJourney> getDailyJourneysByPlan(Long id){
        List<DailyJourney> dailyJourneyList = new ArrayList<>();
        Optional<Plan> plan = planRepository.findById(id);
        plan.ifPresent(value -> dailyJourneyRepository.findByPlan(value).forEach(dailyJourneyList::add));
        return dailyJourneyList;
    }

    public List<DailyJourney> getDailyJourneysByPlanId(Long plan_id){
        List<DailyJourney> dailyJourneyList = new ArrayList<>();
        dailyJourneyRepository.findAllByPlanId(plan_id).forEach(dailyJourneyList::add);
        return dailyJourneyList;
    }

    // no newDailyJourney is needed.

    public Optional<DailyJourney> getDailyJourney(Long id){
        return dailyJourneyRepository.findById(id);
    }

    public DailyJourney updateDailyJourney(Long id, DailyJourney dailyJourney){
        if (dailyJourneyRepository.findById(id).isEmpty()) {
            return null;
        }
        dailyJourney.setId(id);
        return dailyJourneyRepository.save(dailyJourney);
    }


    public String removeDailyJourney(Long id){
        dailyJourneyRepository.deleteById(id);
        return "ok";
    }
}
