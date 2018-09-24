package com.example.nogahblum.carrotmonster;

import java.util.ArrayList;

public class Monster {

    // globals:
    public static final int DEFAULT_LEVEL = 0;
    public static final int GOOD_HEALTH = 3;
    public static final int NORMAL_HEALTH = 2;
    public static final int BAD_HEALTH = 1;
    public static final int DEATH = 0;

    // Monster fields:
    private int level;
    private int health;
    private ArrayList<String> goodFood;
    private ArrayList<String> badFood;

    // Monster constructor
    public Monster(ArrayList<String> goodFood, ArrayList<String> badFood)
    {
        this.level = DEFAULT_LEVEL;
        this.health = GOOD_HEALTH;
        this.goodFood = goodFood;
        this.badFood = badFood;
    }

    // getters:

    int getLevel()
    {
        return level;
    }

    int getHealth()
    {
        return health;
    }

    ArrayList<String> getGoodFood()
    {
        return goodFood;
    }

    ArrayList<String> getBadFood()
    {
        return badFood;
    }

    // setters:

    void setLevel(int newLevel)
    {
        this.level = newLevel;
    }

    void setHealth(int newHealth)
    {
        this.health = newHealth;
    }

}
