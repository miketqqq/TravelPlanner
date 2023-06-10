package com.mike.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/views")
public class ViewController {

    @Autowired
    private ViewService viewService;

    @GetMapping("")
    public List<View> getAllView(){
        //for debug or superUser
        return viewService.getAllViews();
    }
}
