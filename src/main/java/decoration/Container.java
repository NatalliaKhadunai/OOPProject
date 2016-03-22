package decoration;

public class Container extends Decoration {
    private ContainerType type;
    private boolean transparent;

    public Container(String material, String color, int cost) {
        super(material, color, cost);
    }

    public void setType(String type) {
        this.type = ContainerType.valueOf(type);
    }

    public String getType() {
        return type.name();
    }

    public void setTransparent(boolean isTransparent) {
        transparent = isTransparent;
    }

    public boolean isTransparent() {
        return transparent;
    }

    @Override
    public String toString() {
        return super.toString() + " { Container { " + "type = " + type + ", transparent = " + transparent + " }}}";
    }

    @Override
    public int hashCode() {
        return super.hashCode() + type.ordinal() + (transparent==true?1:0);
    }
}