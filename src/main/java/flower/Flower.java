/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flower;

import org.apache.log4j.Logger;

public abstract class Flower {
    private String name, color;
    private int cost;
    private Freshness freshness;
    private final boolean artificial;
    
    Flower(String name, String color, boolean isArtificial) {
        this.name = name;
        this.color = color;
        this.artificial = isArtificial;
        this.cost = 1;
        this.freshness = Freshness.MIDDLE_FRESH;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public int getCost() { return this.cost; }
    
    public void setFreshness(String freshness) {
        this.freshness = Freshness.valueOf(freshness);
    }
    
    public String getFreshness() {
        return freshness.name();
    }

    int getFreshnessOrdinal() {
        return freshness.ordinal();
    }

    public boolean IsArtificial() {
        return artificial;
    }

    @Override
    public String toString() {
        return "Flower { " + "name = '" + name + '\'' + ", color = '" + color + '\'' + ", cost = " + cost +
                ", freshness = " + freshness + ", isArtificial = " + artificial;
    }
}