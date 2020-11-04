package eu.relcfart.conditionaltranformation.examples;

public class FastCar extends Car {

    public FastCar(float prize) {
        super(prize);
    }

    @Override
    public String getDescription() {
        return "fast";
    }

    @Override
    int getMaxSpeedFactor() {
        return 3;
    }
}
