package flower;

public class PotFlower extends Flower {
    private int height, potVolume;

    public PotFlower(String name, String color, boolean isArtificial) {
        super(name, color, isArtificial);
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setPotVolume(int potVolume) {
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
