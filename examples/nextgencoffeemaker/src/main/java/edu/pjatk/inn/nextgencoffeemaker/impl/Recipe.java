package edu.pjatk.inn.nextgencoffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.io.Serializable;


/**
 * COPYRIGHT (C) 2016 PJATK. All Rights Reserved.
 * Recipe class.
 * Solves homework assignment #2
 *
 * @author PJATK
 * @version 1.01 2016-01-20
 */
public class Recipe implements Serializable {

    /** name Drink's Recipe name */
    private String name;

    /** price Drink's price */
    private int price;

    /** amtCoffee amount of the Coffee used in Recipe */
    private int amtCoffee;

    /** amtMilk amount of the Milk used in Recipe */
    private int amtMilk;

    /** amtSugar amount of the Sugar used in Recipe */
    private int amtSugar;

    /** amtChocolate amount of the Chocolate used in Recipe */
    private int amtChocolate;

    /**
     * Constructor initializing all integer instance variables with zeroes
     * and setting name to an empty string/
     */
    public Recipe() {
        this.name = "";
        this.price = 0;
        this.amtCoffee = 0;
        this.amtMilk = 0;
        this.amtSugar = 0;
        this.amtChocolate = 0;
    }

    /**
     * @return Returns the amtChocolate.
     */
    public int getAmtChocolate() {
        return amtChocolate;
    }

    /**
     * @param amtChocolate The amtChocolate to set.
     */
    public void setAmtChocolate(int amtChocolate) {
        if (amtChocolate >= 0) {
            this.amtChocolate = amtChocolate;
        }
    }

    /**
     * @return Returns the amtCoffee.
     */
    public int getAmtCoffee() {
        return amtCoffee;
    }

    /**
     * @param amtCoffee The amtCoffee to set.
     */
    public void setAmtCoffee(int amtCoffee) {
        if (amtCoffee >= 0) {
            this.amtCoffee = amtCoffee;
        }
    }

    /**
     * @return Returns the amtMilk.
     */
    public int getAmtMilk() {
        return amtMilk;
    }

    /**
     * @param amtMilk The amtMilk to set.
     */
    public void setAmtMilk(int amtMilk) {
        if (amtMilk >= 0) {
            this.amtMilk = amtMilk;
        }
    }

    /**
     * @return Returns the amtSugar.
     */
    public int getAmtSugar() {
        return amtSugar;
    }

    /**
     * @param amtSugar The amtSugar to set.
     */
    public void setAmtSugar(int amtSugar) {
        if (amtSugar >= 0) {
            this.amtSugar = amtSugar;
        }
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    /**
     * @return Returns the price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price The price to set.
     */
    public void setPrice(int price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    /**
     * @param r Recipe to compare
     * @return Returns boolean value.
     */
    public boolean equals(Recipe r) {
        if ((this.name).equals(r.getName())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return name;
    }

    /**
     * @param context Current context
     * @return Created Recipe instance
     * @throws ContextException
     */
    static public Recipe getRecipe(Context context) throws ContextException {
        Recipe r = new Recipe();
        r.name = (String) context.getValue("name");
        r.price = (int) context.getValue("price");
        r.amtCoffee = (int) context.getValue("amtCoffee");
        r.amtMilk = (int) context.getValue("amtMilk");
        r.amtSugar = (int) context.getValue("amtSugar");
        r.amtChocolate = (int) context.getValue("amtChocolate");
        return r;
    }

    /**
     * @param recipe
     * @return
     * @throws ContextException
     */
    static public Context getContext(Recipe recipe) throws ContextException {
        Context cxt = new ServiceContext();
        cxt.putValue("name", recipe.getName());
        cxt.putValue("price", recipe.getPrice());
        cxt.putValue("amtCoffee", recipe.getAmtCoffee());
        cxt.putValue("amtMilk", recipe.getAmtMilk());
        cxt.putValue("amtSugar", recipe.getAmtSugar());
        cxt.putValue("amtChocolate", recipe.getAmtChocolate());
        return cxt;
    }


}
