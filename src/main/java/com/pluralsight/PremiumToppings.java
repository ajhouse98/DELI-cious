package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class PremiumToppings extends Sandwich {
    boolean steak;
    boolean ham;
    boolean salami;
    boolean roastBeef;
    boolean chicken;
    boolean bacon;
    boolean american;
    boolean provolone;
    boolean cheddar;
    boolean swiss;

    public PremiumToppings(int sandwichLength, boolean isToasted, List<String> meats, List<String> cheeses,
                           List<String> toppings, List<String> sauces, boolean steak, boolean ham, boolean salami,
                           boolean roastBeef, boolean chicken, boolean bacon, boolean american, boolean provolone,
                           boolean cheddar, boolean swiss) {
        super(sandwichLength, isToasted, meats, cheeses, toppings, sauces);
        this.steak = steak;
        this.ham = ham;
        this.salami = salami;
        this.roastBeef = roastBeef;
        this.chicken = chicken;
        this.bacon = bacon;
        this.american = american;
        this.provolone = provolone;
        this.cheddar = cheddar;
        this.swiss = swiss;
    }

    public boolean getSteak() {
        return steak;
    }

    public boolean getHam() {
        return ham;
    }

    public boolean getSalami() {
        return salami;
    }

    public boolean getRoastBeef() {
        return roastBeef;
    }

    public boolean getChicken() {
        return chicken;
    }

    public boolean getBacon() {
        return bacon;
    }

//    @Override
//    public double getPrice() {
//        return price;
//    }
}
