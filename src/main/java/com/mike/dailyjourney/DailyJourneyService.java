package com.mike.dailyjourney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DailyJourneyService {

    @Autowired
    private DailyJourneyRepository dailyJourneyRepository;


    public List<DailyJourney> getAllDailyJourneys(){
        List<DailyJourney> dailyJourneyList = new ArrayList<>();
        dailyJourneyRepository.findAll().forEach(dailyJourneyList::add);
        return dailyJourneyList;
    }

    // no newDailyJourney is needed.

    public Optional<DailyJourney> getDailyJourney(Long id){
        return dailyJourneyRepository.findById(id);
    }

    public DailyJourney updateDailyJourney(Long id, DailyJourney dailyJourney){
        dailyJourney.setId(id);
        return dailyJourneyRepository.save(dailyJourney);
    }


    public String removeDailyJourney(Long id){
        dailyJourneyRepository.deleteById(id);
        return "ok";
    }
}
