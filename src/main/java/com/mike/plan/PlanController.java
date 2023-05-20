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

    @GetMapping("/test")
    public String home(){
        return "{\"a\" : \"b\" \r\n \"c\"}";
    }

    @GetMapping("")
    public List<PlanModel> getAllPlans(){
        return planService.getAllPlans();
    }

    @PostMapping()
    public PlanModel newPlan(@RequestBody PlanModel plan){
        return planService.newPlan(plan);
    }

    @GetMapping("/{id}")
    public Optional<PlanModel> getPlan(@PathVariable("id") Long id){
        return planService.getPlan(id);
    }

    @DeleteMapping("/{id}")
    public String removePlan(@PathVariable("id") Long id){
        return planService.removePlan(id);
    }

}
