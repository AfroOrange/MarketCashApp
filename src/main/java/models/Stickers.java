package models;

import java.util.Objects;

public class Stickers {

    private String name;
    private String size;
    private double price;
    private int quantity;

    public Stickers (String name, String size, double price, int quantity) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (Objects.equals(size, "Large")) {
            setPrice(1.5);
        } else if (Objects.equals(size, "Small")) {
            setPrice(1);
        }

        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return name; // or return name + " - " + format for Prints
    }

}
