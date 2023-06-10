package com.mike.dailyjourney;

import com.mike.numberofday.NumberOfDay;
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

    @PostMapping("/")
    public DailyJourney createDailyJourney(
        @RequestBody DailyJourney dailyJourney ){

        return dailyJourneyService.createDailyJourney(dailyJourney);
    }

//    @PutMapping("/{id}")
//    public DailyJourney updateDailyJourney(
//        @PathVariable("id") Long id,
//        @RequestBody DailyJourney dailyJourney ){
//
//        return dailyJourneyService.updateDailyJourney(id, dailyJourney);
//    }

    @PutMapping("/{journey_id}/swap/{other_journey_id}")
    public String swapDailyJourney(
        @PathVariable("journey_id") Long journey_id,
        @PathVariable("other_journey_id") Long other_journey_id ){

        return dailyJourneyService.swapDay(journey_id, other_journey_id);
    }

    // no delete is needed, but need to clear all views.
    @DeleteMapping("/{id}")
    public String clearDailyJourney(@PathVariable("id") Long id){
        return dailyJourneyService.clearDailyJourney(id);
    }


    // --------------------views related------------------------------
    //<editor-fold desc="views">
    @GetMapping("/{journey_id}/views")
    public List<View> getAllView(
        @PathVariable(name="journey_id") Long journey_id ){

        return viewService.getAllViewsByJourneyId(journey_id);
    }

    @GetMapping("/{journey_id}/views/{view_id}")
    public Optional<View> getView(
        @PathVariable(name="view_id") Long view_id ){

        return viewService.getView(view_id);
    }


    @PostMapping("/{journey_id}/views")
    public View createView(
        @PathVariable("journey_id") Long journey_id,
        @RequestBody View view ){

        return viewService.createViews(journey_id, view);
    }


    @PutMapping("/{journey_id}/views/{view_id}")
    public View updateView(
        @PathVariable("journey_id") Long journey_id,
        @PathVariable("view_id") Long view_id,
        @RequestBody View view ){

        return viewService.updateView(view, view_id, journey_id);
    }

    @PutMapping("/{journey_id}/views/{view_id}/swap/{other_view_id}")
    public View swapView(
        @PathVariable("view_id") Long view_id,
        @PathVariable("other_view_id") Long other_view_id ){

        return viewService.swapView(view_id, other_view_id);

    }

    @DeleteMapping("/{journey_id}/views/{view_id}")
    public String removeView(
            @PathVariable("journey_id") Long journey_id,
            @PathVariable("view_id") Long view_id
    ){
        return viewService.removeView(journey_id, view_id);
    }

    //</editor-fold>

}
