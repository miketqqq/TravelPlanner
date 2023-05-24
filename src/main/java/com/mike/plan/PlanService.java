package com.mike.plan;

import com.mike.dailyjourney.DailyJourney;
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

    public List<Plan> getAllPlans(){
        if (planRepository.count() == 0){

            LocalDate now = LocalDate.of(2023,5,18);
            Plan plan = new Plan("japan 5days", "japan", now, now);
            Plan plan2 = new Plan("taiwan 5days", "taiwan", now, now);
            Plan plan3 = new Plan("HK 5days", "HK", now, now);

            planRepository.save(plan);
            planRepository.save(plan2);
            planRepository.save(plan3);
        }

        List<Plan> dailyJourneyModelList = new ArrayList<>();
        planRepository.findAll().forEach(dailyJourneyModelList::add);
        return dailyJourneyModelList;
    }

    public Plan createPlan(Plan plan){
        //plan.setDuration();  //may override save() method in repository
        Plan newPlan;
        Long id;

        //if plan already exist, just save it.
        if ((id = plan.getId()) != null && planRepository.findById(id).isPresent()){
            //return responseEntity saying that object exist
            newPlan = planRepository.save(plan);
        } else {
            newPlan = planRepository.save(plan);
            //ArrayList<DailyJourney> newJourneys = PlanJourneyHandler.createJourneys(newPlan);
            //dailyJourneyRepository.saveAll(newJourneys);
        }

        return newPlan;
    }

    public Optional<Plan> getPlan(Long id){
        return planRepository.findById(id);
    }

    public Plan updatePlan(Long id, Plan plan){
        if (planRepository.findById(id).isEmpty()) {
            return null;
        }
        plan.setId(id);
        //plan.setDuration();
        return planRepository.save(plan);
    }


    public String removePlan(Long id){
        if (planRepository.findById(id).isPresent()){
            planRepository.deleteById(id);
            return "ok";
        } else {
            return "no record is deleted";
        }

    }


}
