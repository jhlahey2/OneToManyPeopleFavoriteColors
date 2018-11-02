package com.jackseb.demo.Controller;

import com.jackseb.demo.Model.Color;
import com.jackseb.demo.Model.ColorRepository;
import com.jackseb.demo.Model.Person;
import com.jackseb.demo.Model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    PersonRepository people;
    @Autowired
    ColorRepository favoritecolors;

    //
//    @RequestMapping("/")
//    public String index(Model model){
//
//        model.addAttribute("people", people.findAll());
//        return "listpeople";
//    }
    @RequestMapping("/")
    public String index() {

//        System.out.println("we are in @RequestMapping(\"/\")  ");
        return "index";
    }

    @RequestMapping("/home")
    public String home() {

//        System.out.println("we are in @RequestMapping(\"/\")  ");
        return "homepage";
    }

    @RequestMapping("/list")
    public String listPeople(Model model) {
//        System.out.println("we are in /list  ");

        model.addAttribute("people", people.findAll());
        return "list";
    }

    @RequestMapping("/add")
    public String add(Model model) {
//        System.out.println("we are in /list  ");

        model.addAttribute("person", new Person());

        return "addform";
    }

    @PostMapping("/process")
    public String process(Person person, @RequestParam String color1, @RequestParam String color2, @RequestParam String color3) {
//        System.out.println("we are in /list  ");
        Color favcolor1 = new Color();
        favcolor1.setColorName(color1);
        Color favcolor2 = new Color();
        favcolor2.setColorName(color2);
        Color favcolor3 = new Color();
        favcolor3.setColorName(color3);

        Set<Color> colors = new HashSet<Color>();
        colors.add(favcolor1);
        colors.add(favcolor2);
        colors.add(favcolor3);
        person.setFavoriteColors(colors);
        favcolor1.setPerson(person);
        favcolor2.setPerson(person);
        favcolor3.setPerson(person);

        people.save(person);



        return "redirect:/home";
    }

    @GetMapping("/search")
    public String search() {
//        System.out.println("we are in /list  ");

        return "search";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam String name) {
//        System.out.println("we are in /list  ");

        model.addAttribute("people", people.findAllByName(name));

        return "search";
    }


}
