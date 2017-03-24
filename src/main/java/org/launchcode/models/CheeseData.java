package org.launchcode.models;

import java.util.ArrayList;

/**
 * Created by Patrick on 3/22/2017.
 */
public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // getAll
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    public static Cheese getById(int id) {
        Cheese theCheese = null;

        for (Cheese candidateCheese : cheeses) {
            if(candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }


        return theCheese;
    }
}