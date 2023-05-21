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
    public List<DailyJourneyModel> getDailyJourneys(){
        return dailyJourneyService.getAllDailyJourneys();
    }

    @GetMapping("/{id}")
    public Optional<DailyJourneyModel> getDailyJourney(@PathVariable("id") Long id){
        return dailyJourneyService.getDailyJourney(id);
    }

    // no newDailyJourney is needed

    @PutMapping("/{id}")
    public DailyJourneyModel updateDailyJourney(@PathVariable("id") Long id, @RequestBody DailyJourneyModel dailyJourney){
        return dailyJourneyService.updateDailyJourney(id, dailyJourney);
    }

    @DeleteMapping("/{id}")
    public String removeDailyJourney(@PathVariable("id") Long id){
        return dailyJourneyService.removeDailyJourney(id);
    }

}
