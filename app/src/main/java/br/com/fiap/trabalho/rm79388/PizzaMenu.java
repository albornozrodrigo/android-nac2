package br.com.fiap.trabalho.rm79388;

public class PizzaMenu {
    private int id;
    private String name;
    private int img;
    private int price;
    private int points;
    private int calories;
    private String observations;

    public PizzaMenu() {}
    public PizzaMenu(String name, int img, int price, int points, int calories, String observations) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.points = points;
        this.calories = calories;
        this.observations = observations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
