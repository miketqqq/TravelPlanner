package com.mike.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/views")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @GetMapping("/views")
    public List<View> getAllView(){
        //for debug
        return viewService.getAllViews();
    }
}
