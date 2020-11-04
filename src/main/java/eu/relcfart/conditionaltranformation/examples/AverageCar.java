package eu.relcfart.conditionaltranformation.examples;

public class AverageCar extends Car {
    public AverageCar(float prize) {
        super(prize);
    }

    @Override
    public String getDescription() {
        return "average";
    }

    @Override
    int getMaxSpeedFactor() {
        return 2;
    }
}
