package eu.relcfart.conditionaltranformation.examples;

public abstract class Car {
    private float prize;

    public Car(float prize) {
        this.prize = prize;
    }

    public abstract String getDescription();

    public int getMaxSpeed() {
        return Math.round(prize * getMaxSpeedFactor());
    }

    abstract int getMaxSpeedFactor();


}
