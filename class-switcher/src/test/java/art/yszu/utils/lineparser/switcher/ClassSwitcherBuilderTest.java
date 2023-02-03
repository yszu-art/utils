package art.yszu.utils.lineparser.switcher;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ClassSwitcherBuilderTest {

    @Test
    void switchForNull() {
        //when then
        assertThrows(NullPointerException.class, () ->
                ClassSwitcher.switchFor(null));
    }

    @Test
    void caseForNullClazz() {
        //when then
        assertThrows(NullPointerException.class, () ->
                ClassSwitcher.switchFor(1).caseFor(null, o -> {
                }));
    }

    @Test
    void caseForNullConsumer() {
        //when then
        assertThrows(NullPointerException.class, () ->
                ClassSwitcher.switchFor(1).caseFor(Integer.class, null));
    }

    @Test
    void caseForInteger() {
        //given
        Object o = 1;
        Consumer<Integer> integerConsumer = consumerMock();
        Consumer<Integer> intConsumer = consumerMock();
        Runnable defaultConsumer = mock(Runnable.class);

        //when
        ClassSwitcher.switchFor(o)
                     .caseFor(Integer.TYPE, intConsumer)
                     .caseFor(Integer.class, integerConsumer)
                     .defaultCase(defaultConsumer);

        //then
        verify(integerConsumer).accept(1);
        verifyNoInteractions(intConsumer);
        verifyNoInteractions(defaultConsumer);
    }

    @Test
    void defaultCase() {
        //given
        Object o = 1;
        Consumer<String> stringConsumer = consumerMock();
        Consumer<Float> floatConsumer = consumerMock();
        Runnable defaultConsumer = mock(Runnable.class);

        //when
        ClassSwitcher.switchFor(o)
                     .caseFor(Float.class, floatConsumer)
                     .caseFor(String.class, stringConsumer)
                     .defaultCase(defaultConsumer);

        //then
        verify(defaultConsumer).run();
        verifyNoInteractions(stringConsumer);
        verifyNoInteractions(floatConsumer);
    }


    @Test
    void switchForWithResultAndDefaultCase() {
        //given
        Object o = 1;
        Function<Integer, String> integerFunction = functionMock();
        Function<Float, String> floatFunction = functionMock();
        when(integerFunction.apply(any())).thenReturn("mocked");

        //when
        String result = ClassSwitcher
                .switchFor(o)
                .withResult(String.class)
                .caseFor(Integer.class, integerFunction)
                .caseFor(Float.class, floatFunction)
                .defaultCase(() -> "default");

        //then
        assertEquals("mocked", result);
    }

    @Test
    void switchForWithGetResultOptional() {
        //given
        Object o = 1;
        Function<Integer, String> integerFunction = functionMock();
        Function<Float, String> floatFunction = functionMock();
        when(integerFunction.apply(any())).thenReturn("mocked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //when
        Optional<String> result = ClassSwitcher
                .switchFor(o).withResult(String.class)
                .caseFor(Integer.class, integerFunction)
                .caseFor(Float.class, floatFunction)
                .getResult();

        //then
        assertEquals(Optional.of("mocked"), result);
        verify(integerFunction).apply(1);
        verifyNoInteractions(floatFunction);
    }

    @Test
    void switchForWithResultEmpty() {
        //given
        Object o = 1;
        Function<Double, String> doubleFunction = functionMock();
        Function<Float, String> floatFunction = functionMock();

        //when
        Optional<String> result = ClassSwitcher
                .switchFor(o)
                .withResult(String.class)
                .caseFor(Double.class, doubleFunction)
                .caseFor(Float.class, floatFunction)
                .getResult();

        //then
        assertEquals(Optional.empty(), result);
        verifyNoInteractions(doubleFunction);
        verifyNoInteractions(floatFunction);
    }

    @Test
    void switchForWithResultDefaultValue() {
        //given
        Object o = 1;
        Function<Double, String> doubleFunction = functionMock();
        Function<Float, String> floatFunction = functionMock();

        //when
        String result = ClassSwitcher
                .switchFor(o)
                .withResult(String.class)
                .caseFor(Double.class, doubleFunction)
                .caseFor(Float.class, floatFunction)
                .defaultCase(() -> "default");

        //then
        assertEquals("default", result);
    }

    private static <T> Consumer<T> consumerMock() {
        @SuppressWarnings("unchecked")
        Consumer<T> mock = mock(Consumer.class);
        return mock;
    }

    private static <T, R> Function<T, R> functionMock() {
        @SuppressWarnings("unchecked")
        Function<T, R> mock = mock(Function.class);
        return mock;
    }

}