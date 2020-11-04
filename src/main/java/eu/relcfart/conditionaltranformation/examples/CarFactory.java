package eu.relcfart.conditionaltranformation.examples;


import eu.relcfart.conditionaltranformation.ConditionalTransformation;

public class CarFactory {
    private static final float FAST_CAR_MIN_PRIZE = 300;
    private static final float AVERAGE_CAR_MIN_PRIZE = 200;
    private static final float SLOW_CAR_MIN_PRIZE = 100;

    public static Car getCar(float prize) {
        return new ConditionalTransformation<Float, Car>()
                .addCase(p -> p >= FAST_CAR_MIN_PRIZE, FastCar::new)
                .addCase(p -> p >= AVERAGE_CAR_MIN_PRIZE, AverageCar::new)
                .addCase(p -> p >= SLOW_CAR_MIN_PRIZE, SlowCar::new)
                .transform(prize)
                .orElseThrow((() -> new RuntimeException("You can't afford any car!")));
    }
}
