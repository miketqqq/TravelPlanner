package com.mike.dailyjourney;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface DailyJourneyRepository extends CrudRepository<DailyJourney, Long> {

    DailyJourney findByDate(LocalDate date);

}
