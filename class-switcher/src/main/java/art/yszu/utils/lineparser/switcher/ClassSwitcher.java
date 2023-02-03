package art.yszu.utils.lineparser.switcher;


import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface ClassSwitcher {

    static ClassSwitcher switchFor(Object object) {
        Objects.requireNonNull(object);
        return new ClassSwitcherBuilder<>(object);
    }

    <T> ClassSwitcherCase caseFor(Class<T> type, Consumer<T> consumer);

    interface ClassSwitcherCase {
        <T> ClassSwitcherCase caseFor(Class<T> type, Consumer<T> consumer);
        void defaultCase(Runnable consumer);
    }

    <R> ClassSwitcherWithResult<R> withResult(Class<R> resultType);

    interface ClassSwitcherWithResult<R> {

        <T> ClassSwitcherCase<R> caseFor(Class<T> type, Function<T, R> function);

        interface ClassSwitcherCase<R> {
            <T> ClassSwitcherCase<R> caseFor(Class<T> type, Function<T, R> function);
            R defaultCase(Supplier<R> function);
            Optional<R> getResult();
        }
    }

}
