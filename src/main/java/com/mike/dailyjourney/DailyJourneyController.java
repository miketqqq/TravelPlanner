package com.mike.dailyjourney;

import com.mike.view.View;
import com.mike.view.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/daily-journeys")
public class DailyJourneyController {

    @Autowired
    private DailyJourneyService dailyJourneyService;

    @Autowired
    private ViewService viewService;


    @GetMapping("")
    public List<DailyJourney> getAllDailyJourneys(){
        //for debug
        return dailyJourneyService.getAllDailyJourneys();
    }

    @GetMapping("/{id}")
    public Optional<DailyJourney> getDailyJourney(@PathVariable("id") Long id){
        return dailyJourneyService.getDailyJourney(id);
    }

//    @GetMapping("/plan/{plan_id}")
//    public List<DailyJourney> getDailyJourneysByPlanId(@PathVariable("plan_id") Long id){
//        return dailyJourneyService.getDailyJourneysByPlanId(id);
//    }

    // no createDailyJourney is needed

    @PutMapping("/{id}")
    public DailyJourney updateDailyJourney(@PathVariable("id") Long id, @RequestBody DailyJourney dailyJourney){
        return dailyJourneyService.updateDailyJourney(id, dailyJourney);
    }

    // no delete is needed, but need to clear all views.
    @DeleteMapping("/{id}")
    public String clearDailyJourney(@PathVariable("id") Long id){
        return dailyJourneyService.clearDailyJourney(id);
    }



    //views related
    @GetMapping("/{journey_id}/views")
    public List<View> getAllView(
        @PathVariable(name="journey_id") Long journey_id
    ){
        return viewService.getAllViewsByJourneyId(journey_id);
    }

    @GetMapping("/{journey_id}/views/{view_id}")
    public Optional<View> getView(
        @PathVariable(name="view_id") Long view_id
    ){
        return viewService.getView(view_id);
    }


    @PostMapping("/{journey_id}/views")
    public View createView(
        @PathVariable("journey_id") Long journey_id,
        @RequestBody View view
    ){
        return viewService.createViews(journey_id, view);
    }


    @PutMapping("/{journey_id}/views/{view_id}")
    public View updateView(
        @PathVariable("journey_id") Long journey_id,
        @PathVariable("view_id") Long view_id,
        @RequestBody View view
    ){
        return viewService.updateView(view, view_id, journey_id);
    }

    @PutMapping("/{journey_id}/views/{view_id}/swap")
    public View swapView(
            @PathVariable("view_id") Long view_id,
            @RequestBody Map<String, String> requestBody
    ){
        if ( !requestBody.containsKey("otherJourneyId")){
            //throw error if no Journey id
            return null;
        }

        Long otherJourneyId = Long.parseLong(requestBody.get("otherJourneyId"));
        return viewService.swapView(view_id, otherJourneyId);

    }
}
