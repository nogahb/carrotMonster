package com.example.nogahblum.carrotmonster;

import android.widget.TableRow;

import java.util.ArrayList;

public class Monster {

    // globals:
    public final int DEFAULT_LEVEL = 0;
    public final int GOOD_HEALTH = 2;
    public final int BAD_HEALTH = 1;
    public final int DEATH = 0;

    // Monster fields:
    String type;
    private int growthCounter;
    private int level;
    private Long last_fed;
    private int health;
    private ArrayList<String> goodFood;
    private ArrayList<String> badFood;


    // Monster constructor
    public Monster(ArrayList<String> goodFood, ArrayList<String> badFood, String type)
    {
        this.type = type;
        this.level = DEFAULT_LEVEL;
        this.growthCounter = DEFAULT_LEVEL;
        this.health = GOOD_HEALTH;
        this.goodFood = goodFood;
        this.badFood = badFood;
        this.last_fed = System.currentTimeMillis()/1000;
        //3600 diff is an hour
    }


    // getters:

    String getType()
    {
        return type;
    }

    int getLevel()
    {
        return level;
    }

    int getGrowthCounter()
    {
        return growthCounter;
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

    void changeLevel(int change) {

        if (change == 1 || change == -1) {
            this.level += change;
            this.growthCounter = 0;
        }
    }

    void changeGrowthCounter(int change) {

        if (change == 1 || change == -1) {
            this.growthCounter += change;
        }
    }//hi

    public String check_on_monster(){
        Long time = System.currentTimeMillis()/1000;
        if ((time-this.last_fed)>(3600*100)){
            return "ded";
        }

        if((time-this.last_fed)>(3600*50)){
            return "hungry";
        }

        return "OK";
    }



}
