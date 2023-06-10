package com.mike.view;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ViewRepository extends CrudRepository<View, Long> {

    Iterable<View> findAllByDailyJourneyId(Long journey_id);

    Optional<View> findByIdAndDailyJourneyId(Long id, Long journey_id);

    int countByDailyJourneyId(Long journey_id);

    void deleteByDailyJourneyId(Long journey_id);

    void deleteAllByDailyJourneyId(Long journey_id);

}
