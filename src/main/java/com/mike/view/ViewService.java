package com.mike.view;

import com.mike.dailyjourney.DailyJourney;
import com.mike.dailyjourney.DailyJourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    private ViewRepository viewRepository;

    @Autowired
    private DailyJourneyRepository dailyJourneyRepository;

    public List<View> getAllViews(){
        List<View> viewsList = new ArrayList<>();
        viewRepository.findAll().forEach(viewsList::add);
        return viewsList;
    }

    public View createViews(Long journey_id, View view){
        Optional<DailyJourney> journey = dailyJourneyRepository.findById(journey_id);
        journey.ifPresent(
                view::setDailyJourney
        );
        return viewRepository.save(view);
    }

    public Optional<View> getView(Long view_id){
        return viewRepository.findById(view_id);
    }

    public List<View> getAllByDailyJourneyId(Long journey_id){
        List<View> viewsList = new ArrayList<>();
        viewRepository.findAllByDailyJourneyId(journey_id).forEach(viewsList::add);
        return viewsList;
    }

    public View updateView(Long view_id, View view){
        if (viewRepository.findById(view_id).isEmpty()) {
            return null;
        }
        view.setId(view_id);
        return viewRepository.save(view);
    }

    public String removeView(Long view_id){
        viewRepository.deleteById(view_id);
        return "ok";
    }

}
