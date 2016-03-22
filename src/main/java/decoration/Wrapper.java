package decoration;

public class Wrapper extends Decoration {
    private WrapperType type;
    private boolean mat;

    public Wrapper(String material, String color, int cost) {
        super(material, color, cost);
    }

    public void setType(String type) {
        this.type = WrapperType.valueOf(type);
    }

    public String getType() {
        return type.name();
    }

    public void setMat(boolean mat) {
        this.mat = mat;
    }

    public boolean isMat() {
        return mat;
    }

    @Override
    public String toString() {
        return super.toString() + " { Wrapper { " + "type = " + type + ", mat = " + mat + " }}}";
    }

    @Override
    public int hashCode() {
        int hash =  super.hashCode() + type.ordinal() + (mat==true? 1 : 0);
        return hash;
    }
}
