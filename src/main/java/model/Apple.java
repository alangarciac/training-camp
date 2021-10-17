package model;

public class Apple {

    private Color color;
    private String weight;

    public Apple(Color color, String weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                ", weight='" + weight + '\'' +
                '}';
    }
}
