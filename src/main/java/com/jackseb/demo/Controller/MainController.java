package com.jackseb.demo.Controller;

import com.jackseb.demo.Model.ColorRepository;
import com.jackseb.demo.Model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    PersonRepository people;

    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("people", people.findAll());
        return "index";
    }


}
