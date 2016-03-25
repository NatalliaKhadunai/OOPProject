package flower;

import decoration.IDecorable;

public class Foliage extends Flower implements IDecorable {
    private int length;
    private boolean curly;

    public Foliage(String name, String color, boolean isArtificial) {
        super(name, color, isArtificial);
    }

    public void setLength(int length) {
        if (length <=0) {
            this.length = 1;
            return;
        }
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setCurly(boolean isCurly) {
        curly = isCurly;
    }

    public boolean isCurly() {
        return curly;
    }

    @Override
    public String toString() {
        return super.toString() + " { Foliage { " + "length = " + length + ", curly = " + curly + "}}}";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int)Math.pow(length, 2) + (curly==true?1:0);
    }
}
