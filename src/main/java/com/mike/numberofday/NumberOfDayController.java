package com.mike.numberofday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/days")
public class NumberOfDayController {

    @Autowired
    private NumberOfDayService numberOfDayService;


    @GetMapping("")
    public List<NumberOfDay> getAllDay(){
        return numberOfDayService.getAllDays();
    }
}
