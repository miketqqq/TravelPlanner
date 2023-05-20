package com.mike.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public List<PlanModel> getAllPlans(){
        Date now = new Date(2023,5,18);
        PlanModel plan = new PlanModel("japan 5days", "japan", now, now);
        PlanModel plan2 = new PlanModel("taiwan 5days", "taiwan", now, now);
        PlanModel plan3 = new PlanModel("HK 5days", "HK", now, now);

        planRepository.save(plan);
        planRepository.save(plan2);
        planRepository.save(plan3);

        List<PlanModel>  planModelList = new ArrayList<>();
        planRepository.findAll().forEach(planModelList::add);
        return planModelList;
    }

    public PlanModel newPlan(PlanModel plan){
        return planRepository.save(plan);
    }

    public Optional<PlanModel> getPlan(Long id){
        return planRepository.findById(id);
    }

    public String removePlan(Long id){
        String output;
        try {
            planRepository.deleteById(id);
            output = "deleted 1 record";
        } catch (EmptyResultDataAccessException e){
            output = "record not found";
        }
        return output;
    }


}
