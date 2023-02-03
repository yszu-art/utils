package art.yszu.utils.lineparser.switcher;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class ClassSwitcherBuilder<R> implements ClassSwitcher.ClassSwitcherCase, ClassSwitcher.ClassSwitcherWithResult.ClassSwitcherCase<R>, ClassSwitcher, ClassSwitcher.ClassSwitcherWithResult<R> {

    private final Object object;
    private R result;
    private boolean defaultEnabled;

    ClassSwitcherBuilder(Object object) {
        this.object = object;
        this.defaultEnabled = true;
    }

    @Override
    public <T> ClassSwitcherWithResult.ClassSwitcherCase<R> caseFor(Class<T> type, Function<T, R> function) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(function);
        if (object.getClass().equals(type)) {
            result = function.apply(unsafeCase(object));
            defaultEnabled = false;
        }
        return this;
    }

    @Override
    public <T> ClassSwitcher.ClassSwitcherCase caseFor(Class<T> type, Consumer<T> consumer) {
        return (ClassSwitcher.ClassSwitcherCase) caseFor(type, t -> {
            consumer.accept(t);
            return null;
        });
    }

    @Override
    public R defaultCase(Supplier<R> function) {
        if (defaultEnabled) {
            result = function.get();
        }
        return result;
    }

    @Override
    public void defaultCase(Runnable consumer) {
         defaultCase(() -> {
            consumer.run();
            return null;
        });
    }

    @Override
    public <X> ClassSwitcherWithResult<X> withResult(Class<X> resultType) {
        return unsafeCase(this);
    }

    @Override
    public Optional<R> getResult() {
        return Optional.ofNullable(result);
    }


    private static <T> T unsafeCase(Object o) {
        @SuppressWarnings("unchecked")
        T t = (T) o;
        return t;
    }
}
