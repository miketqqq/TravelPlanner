package com.mike.plan;

import com.mike.dailyjourney.DailyJourneyModel;
import com.mike.dailyjourney.DailyJourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private DailyJourneyRepository dailyJourneyRepository;

    public List<PlanModel> getAllPlans(){
        if (planRepository.count() == 0){

            LocalDate now = LocalDate.of(2023,5,18);
            PlanModel plan = new PlanModel("japan 5days", "japan", now, now);
            PlanModel plan2 = new PlanModel("taiwan 5days", "taiwan", now, now);
            PlanModel plan3 = new PlanModel("HK 5days", "HK", now, now);

            planRepository.save(plan);
            planRepository.save(plan2);
            planRepository.save(plan3);
        }

        List<PlanModel> dailyJourneyModelList = new ArrayList<>();
        planRepository.findAll().forEach(dailyJourneyModelList::add);
        return dailyJourneyModelList;
    }

    public PlanModel newPlan(PlanModel plan){
        plan.setDuration();  //may override save() method in repository
        PlanModel newPlan = planRepository.save(plan);

        ArrayList<DailyJourneyModel> newJourneys = PlanJourneyHandler.createJourneys(newPlan);
        dailyJourneyRepository.saveAll(newJourneys);
        return newPlan;
    }

    public Optional<PlanModel> getPlan(Long id){
        return planRepository.findById(id);
    }

    public PlanModel updatePlan(Long id, PlanModel plan){
        if (planRepository.findById(id).isEmpty()) {
            return null;
        }
        plan.setId(id);
        plan.setDuration();
        return planRepository.save(plan);
    }


    public String removePlan(Long id){
        planRepository.deleteById(id);
        return "ok";
    }


}
