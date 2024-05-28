package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class Sauces extends Sandwich {
    boolean mayo;
    boolean mustard;
    boolean ketchup;
    boolean ranch;
    boolean thousandIslands;
    boolean vinaigrette;
    boolean auJus;
    boolean bbqSauce;

    public Sauces(int sandwichLength, boolean isToasted, List<String> meats, List<String> cheeses, List<String> toppings,
                  List<String> sauces, boolean mayo, boolean mustard, boolean ketchup, boolean ranch,
                  boolean thousandIslands, boolean vinaigrette, boolean auJus, boolean bbqSauce) {
        super(sandwichLength, isToasted, meats, cheeses, toppings, sauces);
        this.mayo = mayo;
        this.mustard = mustard;
        this.ketchup = ketchup;
        this.ranch = ranch;
        this.thousandIslands = thousandIslands;
        this.vinaigrette = vinaigrette;
        this.auJus = auJus;
        this.bbqSauce = bbqSauce;
    }

    public boolean hasMayo() {
        return mayo;
    }

    public boolean hasMustard() {
        return mustard;
    }

    public boolean hasKetchup() {
        return ketchup;
    }

    public boolean hasRanch() {
        return ranch;
    }

    public boolean hasThousandIslands() {
        return thousandIslands;
    }

    public boolean hasVinaigrette() {
        return vinaigrette;
    }
}