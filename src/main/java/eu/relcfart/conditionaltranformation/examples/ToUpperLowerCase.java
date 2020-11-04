package eu.relcfart.conditionaltranformation.examples;

import eu.relcfart.conditionaltranformation.ConditionalTransformation;

import java.util.function.Function;
import java.util.function.Predicate;

public class ToUpperLowerCase {

    public static String change(String changing) {
        return new ToUpperLowerCase().execute(changing);
    }

    private String execute(String changing) {
        return new ConditionalTransformation<String, String>()
                .addCase(isFirstCharUpperCase(), String::toUpperCase)
                .addCase(isFirstCharLowerCase(), String::toLowerCase)
                .orDefault(Function.identity())
                .transform(changing)
                .orElse(null);
    }

    private Predicate<String> isFirstCharUpperCase() {
        return (tested) -> isValidToBeTested(tested) && Character.isUpperCase(tested.charAt(0));
    }

    private Predicate<String> isFirstCharLowerCase() {
        return (tested) -> isValidToBeTested(tested) && Character.isLowerCase(tested.charAt(0));
    }

    private boolean isValidToBeTested(String tested) {
        return tested != null && tested.length() > 0;
    }
}
