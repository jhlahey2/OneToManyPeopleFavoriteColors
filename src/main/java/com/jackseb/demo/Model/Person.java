package com.jackseb.demo.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private long personId;
    private String name;

    @OneToMany(mappedBy = "person" ,cascade = CascadeType.ALL)
    private Set<Color> favoriteColors;

    public long getId() {
        return personId;
    }

    public void setId(long id) {
        this.personId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Color> getFavoriteColors() {
        return favoriteColors;
    }

    public void setFavoriteColors(Set<Color> favoriteColors) {
        this.favoriteColors = favoriteColors;
    }

}
