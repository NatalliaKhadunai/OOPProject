package flower;

public class PotFlower extends Flower {
    private int height, potVolume;

    public PotFlower(String name, String color, boolean isArtificial) {
        super(name, color, isArtificial);
    }
    
    public void setHeight(int height) {
        if (height <=0) {
            this.height = 1;
            return;
        }
        this.height = height;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setPotVolume(int potVolume) {
        if (potVolume <=0) {
            this.potVolume = 1;
            return;
        }
        this.potVolume = potVolume;
    }
    
    public int getPotVolume() {
        return this.potVolume;
    }

    @Override
    public String toString() {
        return super.toString() + " { PotFlower { " + "height = " + height + ", potVolume = " + potVolume + "}}}";
    }
}
