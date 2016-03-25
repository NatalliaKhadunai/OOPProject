package flower;

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
        if (length <=0) {
            this.length = 1;
            return;
        }
        this.length = length;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void setBurgeonDiameter(int diameter) {
        if (diameter <=0) {
            this.burgeonDiameter = 1;
            return;
        }
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
