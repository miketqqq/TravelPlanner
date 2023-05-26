package com.mike.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/views")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @GetMapping("")
    public List<View> getDailyJourney(){
        return viewService.getAllViews();
    }

    @PostMapping("/journey/{journey_id}")
    public View createDailyJourney(
        @PathVariable("journey_id") Long journey_id,
        @RequestBody View view
    ){
        return viewService.createViews(journey_id, view);
    }

    @GetMapping("/journey/{journey_id}")
    public List<View> getAllByDailyJourneyId(@PathVariable("journey_id") Long journey_id){
        return viewService.getAllByDailyJourneyId(journey_id);
    }

}
