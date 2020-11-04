package eu.relcfart.conditionaltranformation.examples;

public class SlowCar extends Car {
    public SlowCar(float prize) {
        super(prize);
    }

    @Override
    public String getDescription() {
        return "slow";
    }

    @Override
    int getMaxSpeedFactor() {
        return 1;
    }
}
