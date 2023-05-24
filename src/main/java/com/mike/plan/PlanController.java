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

}
