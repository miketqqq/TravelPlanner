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


    public List<DailyJourneyModel> getAllDailyJourneys(){
        List<DailyJourneyModel> dailyJourneyModelList = new ArrayList<>();
        dailyJourneyRepository.findAll().forEach(dailyJourneyModelList::add);
        return dailyJourneyModelList;
    }

    // no newDailyJourney is needed.

    public Optional<DailyJourneyModel> getDailyJourney(Long id){
        return dailyJourneyRepository.findById(id);
    }

    public DailyJourneyModel updateDailyJourney(Long id, DailyJourneyModel dailyJourney){
        dailyJourney.setId(id);
        return dailyJourneyRepository.save(dailyJourney);
    }


    public String removeDailyJourney(Long id){
        dailyJourneyRepository.deleteById(id);
        return "ok";
    }
}
