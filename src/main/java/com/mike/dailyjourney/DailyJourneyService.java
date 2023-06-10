package com.mike.dailyjourney;


import com.mike.numberofday.NumberOfDay;
import com.mike.view.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DailyJourneyService {

    @Autowired
    private DailyJourneyRepository dailyJourneyRepository;

    @Autowired
    private ViewRepository viewRepository;

    public List<DailyJourney> getAllDailyJourneys(){
        List<DailyJourney> dailyJourneyList = new ArrayList<>();
        dailyJourneyRepository.findAll().forEach(dailyJourneyList::add);
        return dailyJourneyList;
    }

//    public List<DailyJourney> getDailyJourneysByPlanId(Long plan_id){
//        List<DailyJourney> dailyJourneyList = new ArrayList<>();
//        dailyJourneyRepository.findAllByPlanId(plan_id).forEach(dailyJourneyList::add);
//        return dailyJourneyList;
//    }

    public DailyJourney createDailyJourney(DailyJourney dailyJourney){
        return dailyJourneyRepository.save(dailyJourney);
    }

    public Optional<DailyJourney> getDailyJourney(Long id){
        return dailyJourneyRepository.findById(id);
    }

//    public DailyJourney updateDailyJourney(Long id, DailyJourney dailyJourney){
//        if (dailyJourneyRepository.findById(id).isEmpty()) {
//            return null;
//        }
//        dailyJourney.setId(id);
//        return dailyJourneyRepository.save(dailyJourney);
//    }

    public String swapDay(Long journey_id, Long other_journey_id){
        Optional<DailyJourney> thisFind = dailyJourneyRepository.findById(journey_id);
        Optional<DailyJourney> otherFind = dailyJourneyRepository.findById(other_journey_id);

        String swap = "Success";
        try {
            DailyJourney thisDailyJourney = thisFind.get();
            DailyJourney otherDailyJourney = otherFind.get();

            Long thisNumberOfDayID = thisDailyJourney.getNumberOfDayID();
            Long otherNumberOfDayID = otherDailyJourney.getNumberOfDayID();

            thisDailyJourney.setnumberOfDayID(otherNumberOfDayID);
            otherDailyJourney.setnumberOfDayID(thisNumberOfDayID);
            dailyJourneyRepository.saveAll(List.of(thisDailyJourney, otherDailyJourney));

        } catch (NoSuchElementException e){
            swap = "Fail: incorrect journey_ids";
        }

        return swap;
    }


    public String clearDailyJourney(Long journey_id){
        AtomicReference<String> responseString = new AtomicReference<>("cleared all");
        Optional<DailyJourney> dailyJourney = dailyJourneyRepository.findById(journey_id);
        dailyJourney.ifPresentOrElse(
            journey -> {
                journey.getView().clear();
                dailyJourneyRepository.save(journey);
            },
            () -> responseString.set("no record is deleted")
        );
        return responseString.toString();
    }
}
