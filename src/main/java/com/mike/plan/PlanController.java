package com.mike.plan;

import com.mike.dailyjourney.DailyJourney;
import com.mike.numberofday.NumberOfDay;
import com.mike.numberofday.NumberOfDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private NumberOfDayService numberOfDayService;


    @GetMapping("")
    public List<Plan> getAllPlans(){
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Optional<Plan> getPlan(@PathVariable("id") Long id){
        return planService.getPlan(id);
    }

    @PostMapping("")
    public Plan newPlan(@RequestBody Plan plan){
        return planService.createPlan(plan);
    }

    @PutMapping("/{id}")
    public Plan updatePlan(@PathVariable("id") Long id, @RequestBody Plan plan){
        return planService.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public String removePlan(@PathVariable("id") Long id){
        return planService.removePlan(id);
    }


    // days related
    @GetMapping("/{plan_id}/days")
    public List<NumberOfDay> getAllDay(
            @PathVariable("plan_id") Long plan_id
    ){
        return numberOfDayService.getAllDay(plan_id);
    }

    @GetMapping("/{plan_id}/days/{dayNumber}")
    public NumberOfDay getDay(
        @PathVariable("plan_id") Long plan_id,
        @PathVariable("dayNumber") int dayNumber
    ){
        return numberOfDayService.getDay(plan_id, dayNumber);
    }

    @PutMapping("/{plan_id}/days/{dayNumber}")
    public NumberOfDay updateDay(
        @PathVariable("plan_id") Long plan_id,
        @PathVariable("dayNumber") int dayNumber,
        @RequestBody Map<String, Integer> requestBody
    ){
        if (requestBody.isEmpty() || requestBody.get("isSwap").equals(0)){
            return null;
        }

        int otherDayNumber = requestBody.get("otherDayNumber");
        return numberOfDayService.swapDay(plan_id, dayNumber, otherDayNumber);

    }


}
