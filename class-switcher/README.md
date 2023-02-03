# Class Switcher

## Usage example:
```java
import java.util.function.Function;

class UsageExample {
    void switchFor() {
        Object object = someObject();
        ClassSwitcher
                .switchFor(object)
                .caseFor(Integer.class,
                        integer -> System.out.println(integer * 2))
                .caseFor(String.class,
                        System.out::println)
                .caseFor(MyObject.class,
                        myObject -> myObject.performSomeAction())
                .defaultCase(() ->
                        log.info("default value"));
    }

    void switchForWithResult() {
        Object object = someObject();
        String result = ClassSwitcher
                .switchFor(object)
                .withResult(String.class)
                .caseFor(Integer.class,
                        integer -> "integer doubled: " + (integer * 2))
                .caseFor(String.class, Function::identity)
                .caseFor(MyObject.class,
                        myObject -> myObject.performSomeAction().getStringResult())
                .defaultCase(() -> "default value");
    }

    void switchForWithResultOptional() {
        Object object = someObject();
        Optional<String> result = ClassSwitcher
                .switchFor(object)
                .withResult(String.class)
                .caseFor(Integer.class,
                        integer -> "integer doubled: " + (integer * 2))
                .caseFor(String.class, Function::identity)
                .caseFor(MyObject.class,
                        myObject -> myObject.performSomeAction().getStringResult())
                .getResult();
    }
}
```
