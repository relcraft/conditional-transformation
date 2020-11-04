package eu.relcfart.conditionaltranformation;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class ConditionalTransformation<T, R> {
    private Function<T, R> orDefault = anything -> null;
    private List<Case> cases = new LinkedList<>();

    public ConditionalTransformation<T, R> addCase(Predicate<T> condition, Function<T, R> transformation) {
        this.cases.add(new Case(condition, transformation));
        return this;
    }

    public ConditionalTransformation<T, R> orDefault(Function<T, R> defaultTransformation) {
        this.orDefault = defaultTransformation;
        return this;
    }

    public Optional<R> transform(T value) {
        return Optional.ofNullable(this.cases
                .stream()
                .filter(aCase -> aCase.getCondition().test(value))
                .findFirst()
                .orElseGet(getDefaultCase())
                .getTransformation()
                .apply(value));

    }

    private Supplier<Case> getDefaultCase() {
        return () -> new Case(condition -> true, orDefault);
    }

    private class Case {
        private Predicate<T> condition;
        private Function<T, R> transformation;

        Case(Predicate<T> condition, Function<T, R> transformation) {
            this.condition = condition;
            this.transformation = transformation;
        }

        Predicate<T> getCondition() {
            return condition;
        }

        Function<T, R> getTransformation() {
            return transformation;
        }
    }
}