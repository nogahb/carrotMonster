package com.example.nogahblum.carrotmonster;

import android.widget.TableRow;

import java.util.ArrayList;

public class Monster {

    // globals:
    public final int GOOD_HEALTH_LEVEL = 1;
    public final int DEFAULT_HEALTH_LEVEL = 0;
    public final int BAD_HEALTH_LEVEL = -1;

    public final int WIN_GAME = 2;
    public final int GAME_OVER = -2;

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
        this.level = DEFAULT_HEALTH_LEVEL;
        this.growthCounter = 0;
        this.health = DEFAULT_HEALTH_LEVEL;
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

            if (this.level == GAME_OVER) {
                //todo kill monster
                return;
            }

            if (this.level == WIN_GAME) {
                //todo win game
                return;
            }

            this.growthCounter = 0;
        }
    }

    void changeGrowthCounter(int change) {

        if (change == 1 || change == -1) {
            this.growthCounter += change;
        }
    }

    public String check_on_monster() {
        Long time = System.currentTimeMillis()/1000;
        if ((time-this.last_fed)>(3600*100)){
            return "ded";
        }

        if((time-this.last_fed)>(3600*50)){
            return "hungry";
        }

        return "OK";
    }

    public void update_when_fed() {
        this.last_fed = System.currentTimeMillis()/1000;
    }



}
