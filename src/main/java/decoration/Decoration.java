package decoration;

import com.sun.glass.ui.Size;

abstract class Decoration implements IDecorable  {
    private String material, color;
    private Size size;
    private int cost;

    Decoration(String material, String color, int cost) {
        this.material = material;
        this.color = color;
        this.cost = cost;
        size = new Size(1, 1);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setSize(int width, int height) {
        size.width = width;
        size.height = height;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Decoration { " + "material = '" + material + '\'' + ", color = '" + color +
                '\'' + ", size = " + size + ", cost = " + cost;
    }

    @Override
    public int hashCode() {
        int hash = material.hashCode() + color.hashCode() + cost + (int)Math.pow(size.width, 2)
                + (int)Math.pow(size.height, 2) + (int)Math.sqrt(cost);
        return hash;
    }
}