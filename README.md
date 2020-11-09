# conditional-transformation
## How to avoid multi if-else or switch instructions using Java 8 features.
In this repository you can find one of the many ways how to replace if-else or switch instructions
by construction that uses Java 8 new features: streams and lambda expressions.

Let's assume, that you have to transform one object of type T into another of type R by a series of conditions concerning the first object.
For example a string should be transformed to uppercase or lowercase string in according to a case of the first char: 
- (1) if the first char is uppercase the whole string should be uppercase,
- (2) if the first char is lowercase the whole string should be lowercase,
- (3) in other cases our string stays untouched.

It would be nice if you could add predicates and corresponding functions, something like this:
```
(1) addCase(isFirstCharUpperCase(), String::toUpperCase)
(2) addCase(isFirstCharLowerCase(), String::toLowerCase)
(3) orDefault(Function.identity())
``` 
where isFirstCharUpperCase and isFirstCharLowerCase are helper predicate functions.

Methods addCase and orDefault are implemented in **ConditionalTransformation** object 
and usage of this object according to above example you can find in ToUpperLowerCase.java.

Another usage of ConditionalTransformation you can find in CarFactory.java where ConditionalTransformation object
is implemented as a factory method creating various types of car depending on how much you want to spend on it.    
  


