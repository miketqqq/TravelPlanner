package com.mike.dailyjourney;

import com.mike.plan.Plan;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface DailyJourneyRepository extends CrudRepository<DailyJourney, Long> {

    Iterable<DailyJourney> findByDate(LocalDate date);

    Iterable<DailyJourney> findByPlan(Plan plan);

    Iterable<DailyJourney> findAllByPlanId(Long id);

}
