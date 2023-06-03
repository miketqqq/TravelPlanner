package com.mike.numberofday;

import org.springframework.data.repository.CrudRepository;

public interface NumberOfDayRepository extends CrudRepository<NumberOfDay, Long> {

    NumberOfDay findByPlanIdAndDayNumber(Long plan_id, int dayNumber);

    Iterable<NumberOfDay> findAllByPlanId(Long plan_id);

    void deleteByPlanIdAndDayNumber(Long plan_id, int dayNumber);
}
