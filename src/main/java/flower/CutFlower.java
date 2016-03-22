/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flower;

/**
 *
 * @author user
 */
public class CutFlower extends Flower {
    private int length, burgeonDiameter;
    private boolean hasThorns;

    public CutFlower(String name, String color, boolean isArtificial) {
        super(name, color, isArtificial);
    }
    
    public CutFlower(String name, String color, boolean isArtificial, int length, int burgDiam, boolean hasThorns) {
        super(name, color, isArtificial);
        this.length = length;
        this.burgeonDiameter = burgDiam;
        this.hasThorns = hasThorns;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setBurgeonDiameter(int diameter) {
        this.burgeonDiameter = diameter;
    }
    
    public int getBurgeonDiameter() {
        return this.burgeonDiameter;
    }
    
    public void setHasThorns(boolean hasThorns) {
        this.hasThorns = hasThorns;
    }
    
    public boolean HasThorns() {
        return hasThorns;
    }

    @Override
    public String toString() {
        return super.toString() + " { CutFlower { " + "length = " + length + ", burgeonDiameter = " + burgeonDiameter +
                ", hasThorns = " + hasThorns + " }}}";
    }
}
