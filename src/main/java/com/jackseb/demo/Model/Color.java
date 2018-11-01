package com.jackseb.demo.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long colorId;
    private String colorName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public Color(){


    }

    public Color(String name){

        this.colorName = name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //getters & setters
    public long getId() {
        return colorId;
    }

    public void setId(long id) {
        this.colorId = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }


}
