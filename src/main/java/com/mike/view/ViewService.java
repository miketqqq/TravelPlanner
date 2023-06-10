package com.mike.view;

import com.mike.dailyjourney.DailyJourney;
import com.mike.dailyjourney.DailyJourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    private ViewRepository viewRepository;

    @Autowired
    private DailyJourneyRepository dailyJourneyRepository;


    public List<View> getAllViews(){
        //for debug
        List<View> viewsList = new ArrayList<>();
        viewRepository.findAll().forEach(viewsList::add);
        return viewsList;
    }

    public List<View> getAllViewsByJourneyId(Long journey_id){
        List<View> viewsList = new ArrayList<>();
        viewRepository.findAllByDailyJourneyId(journey_id).forEach(viewsList::add);
        return viewsList;
    }

    public View createViews(Long journey_id, View view){
        Optional<DailyJourney> dailyJourney = dailyJourneyRepository.findById(journey_id);
        if (dailyJourney.isEmpty()) return null;

       view.setDailyJourney(journey_id);
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

    public View updateView(View view, Long view_id, Long journey_id){
        if (viewRepository.findByIdAndDailyJourneyId(view_id, journey_id).isEmpty()) {
            return null;
        }
        view.setId(view_id);
        view.setDailyJourney(journey_id);
        return viewRepository.save(view);
    }

    public View swapView(Long view_id, Long otherJourneyId){
        Optional<View> view = viewRepository.findById(view_id);
        if (view.isEmpty()) return null;
        Optional<DailyJourney> otherDailyJourney = dailyJourneyRepository.findById(otherJourneyId);
        if (otherDailyJourney.isEmpty()) return null;

        View swapingView = view.get();
        swapingView.setDailyJourney(otherJourneyId);
        return viewRepository.save(swapingView);

    }

    public String removeView(Long journey_id, Long view_id){
        Optional<DailyJourney> tempDailyJourney = dailyJourneyRepository.findById(journey_id);
        Optional<View> tempView = viewRepository.findById(view_id);
        try {
            View view = tempView.get();
            viewRepository.delete(view);

            DailyJourney dailyJourney = tempDailyJourney.get();
            dailyJourney.getView().remove(view);
            dailyJourneyRepository.save(dailyJourney);
            return "ok";

        } catch (NoSuchElementException e ){
            return "no record is deleted";
        }
    }

}
