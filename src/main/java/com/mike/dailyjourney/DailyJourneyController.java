package com.mike.dailyjourney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/daily-journeys")
public class DailyJourneyController {

    @Autowired
    private DailyJourneyService dailyJourneyService;


    @GetMapping("")
    public List<DailyJourney> getDailyJourneys(
            @RequestParam(required=false, name="date") String dateStr
    ){
        if (dateStr != null) {
            LocalDate date = LocalDate.parse(dateStr);
            return dailyJourneyService.getDailyJourneysByDate(date);
        }
        //TODO: get journey by plan id
        return dailyJourneyService.getAllDailyJourneys();
    }

    @GetMapping("/{id}")
    public Optional<DailyJourney> getDailyJourney(@PathVariable("id") Long id){
        return dailyJourneyService.getDailyJourney(id);
    }

    // no createDailyJourney is needed

    @PutMapping("/{id}")
    public DailyJourney updateDailyJourney(@PathVariable("id") Long id, @RequestBody DailyJourney dailyJourney){
        return dailyJourneyService.updateDailyJourney(id, dailyJourney);
    }

      // no delete is needed, but may need a clear journey.
//    @DeleteMapping("/{id}")
//    public String removeDailyJourney(@PathVariable("id") Long id){
//        return dailyJourneyService.removeDailyJourney(id);
//    }

}
