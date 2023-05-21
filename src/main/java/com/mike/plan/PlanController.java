package com.mike.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private PlanService planService;


    @GetMapping("")
    public List<PlanModel> getAllPlans(){
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Optional<PlanModel> getPlan(@PathVariable("id") Long id){
        return planService.getPlan(id);
    }

    @PostMapping("")
    public PlanModel newPlan(@RequestBody PlanModel plan){
        return planService.newPlan(plan);
    }

    @PutMapping("/{id}")
    public PlanModel updatePlan(@PathVariable("id") Long id, @RequestBody PlanModel plan){
        return planService.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public String removePlan(@PathVariable("id") Long id){
        return planService.removePlan(id);
    }

}
