package com.jackseb.demo.service;

import com.jackseb.demo.Model.Color;
import com.jackseb.demo.Model.ColorRepository;
import com.jackseb.demo.Model.Person;
import com.jackseb.demo.Model.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner{


    @Autowired
    PersonRepository people;

    @Autowired
    ColorRepository colors;

    @Override
    public void run(String... strings) throws Exception{

        Color red = new Color("red");
        Color blue = new Color("blue");
        Color green = new Color("green");
        Color yellow = new Color("yellow");
        Color purple = new Color("purple");
        Color pink = new Color("pink");
        Color orange = new Color("orange");
        Color black = new Color("black");
        Color white = new Color("white");

        Person person1 = new Person();
        person1.setName("Bob");
        Set<Color> tempSet;
        tempSet = new HashSet<Color>();
        tempSet.add(red);
        tempSet.add(green);
        tempSet.add(blue);
        person1.setFavoriteColors(tempSet);
        red.setPerson(person1);
        green.setPerson(person1);
        blue.setPerson(person1);

        Person person2 = new Person();
        person2.setName("Jack");
        tempSet = new HashSet<Color>();
        tempSet.add(yellow);
        tempSet.add(purple);
        tempSet.add(pink);
        person2.setFavoriteColors(tempSet);
        yellow.setPerson(person2);
        purple.setPerson(person2);
        pink.setPerson(person2);

        Person person3 = new Person();
        person3.setName("Seble");
        tempSet = new HashSet<Color>();
        tempSet.add(orange);
        tempSet.add(black);
        tempSet.add(white);
        person3.setFavoriteColors(tempSet);
        orange.setPerson(person3);
        black.setPerson(person3);
        white.setPerson(person3);

        people.save(person1);
        people.save(person2);
        people.save(person3);

        colors.save(red);
        colors.save(blue);
        colors.save(green);
        colors.save(yellow);
        colors.save(purple);
        colors.save(pink);
        colors.save(orange);
        colors.save(black);
        colors.save(white);


    }




}
