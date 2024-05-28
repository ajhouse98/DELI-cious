package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class Toppings extends Sandwich {

    boolean lettuce;
    boolean peppers;
    boolean onions;
    boolean tomatoes;
    boolean jalapenos;
    boolean cucumbers;
    boolean pickles;
    boolean guacamole;
    boolean mushrooms;

    public Toppings(int sandwichLength, boolean isToasted, List<String> meats, List<String> cheeses,
                    List<String> toppings, List<String> sauces, boolean lettuce, boolean peppers, boolean onions,
                    boolean tomatoes, boolean jalapenos, boolean cucumbers, boolean pickles, boolean guacamole,
                    boolean mushrooms) {
        super(sandwichLength, isToasted, meats, cheeses, toppings, sauces);
        this.lettuce = lettuce;
        this.peppers = peppers;
        this.onions = onions;
        this.tomatoes = tomatoes;
        this.jalapenos = jalapenos;
        this.cucumbers = cucumbers;
        this.pickles = pickles;
        this.guacamole = guacamole;
        this.mushrooms = mushrooms;
    }

    public boolean hasLettuce() {
        return lettuce;
    }

    public boolean hasPeppers() {
        return peppers;
    }

    public boolean hasOnions() {
        return onions;
    }

    public boolean hasTomatoes() {
        return tomatoes;
    }

    public boolean hasJalapenos() {
        return jalapenos;
    }

    public boolean hasCucumbers() {
        return cucumbers;
    }

    public boolean hasPickles() {
        return pickles;
    }

    public boolean hasGuacamole() {
        return guacamole;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }
}