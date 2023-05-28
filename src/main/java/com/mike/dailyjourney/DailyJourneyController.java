package com.mike.dailyjourney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/daily-journeys")
public class DailyJourneyController {

    @Autowired
    private DailyJourneyService dailyJourneyService;


    @GetMapping("")
    public List<DailyJourney> getAllDailyJourneys(
            @RequestParam(required=false, name="date") String dateStr,
            @RequestParam(required=false, name="plan_id") Long plan_id
    ){
        List<DailyJourney> dailyJourneys = dailyJourneyService.getAllDailyJourneys();
//        if (dateStr != null) {
//            LocalDate date = LocalDate.parse(dateStr);
//            dailyJourneys = dailyJourneys.stream().filter(journey -> journey.getDate().isEqual(date)).toList();
//        }
//        if (plan_id != null) {
//            dailyJourneys = dailyJourneys.stream().filter(journey -> journey.getPlan() == plan_id).toList();
//            //return dailyJourneyService.getDailyJourneysByPlanId(plan_id);
//        }
        return dailyJourneys;
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

}
