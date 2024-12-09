package com.company.Abstraction.trafficLights;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void changeColor() {
        switch (this.color) {
            case RED -> this.color = Color.GREEN;
            case GREEN -> this.color = Color.YELLOW;
            case YELLOW -> this.color = Color.RED;
        }
    }
}
