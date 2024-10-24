package models;

import java.util.Objects;

public class Prints {

    private String name;
    private String format;
    private double price;
    private int quantity;

    public Prints(String name, String format, double price, int quantity) {
        this.name = name;
        this.format = format;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (Objects.equals(format, "A4")) {
            setPrice(5);
        } else if (Objects.equals(format, "A3")) {
            setPrice(3);
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return name; // or return name + " - " + format for Prints
    }

}
