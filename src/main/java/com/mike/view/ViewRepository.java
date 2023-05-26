package com.mike.view;

import com.mike.dailyjourney.DailyJourney;
import org.springframework.data.repository.CrudRepository;

public interface ViewRepository extends CrudRepository<View, Long> {

    Iterable<View> findAllByDailyJourneyId(Long id);

}
