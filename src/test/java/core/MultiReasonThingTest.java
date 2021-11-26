package core;

import org.junit.jupiter.api.Test;
import runner.MutableVoidDoWorkHandler;
import runner.ResultDoWorkFactory;
import runner.mapper.StringResultMapper;
import runner.sideEffect.PrintSideEffects;

import static org.assertj.core.api.Assertions.assertThat;

class MultiReasonThingTest {

    @Test
    public void canHandleAVisaCard() {
        MultiReasonThing multiReasonThing = new MultiReasonThing();

        MutableVoidDoWorkHandler handler = new MutableVoidDoWorkHandler();
        multiReasonThing.voidDoWork("a Visa card", handler);

        assertThat(handler.wasVisa()).isTrue();
    }

    @Test
    public void nicerWay() {
        MultiReasonThing multiReasonThing = new MultiReasonThing();

        ResultDoWorkHandler handler = new ResultDoWorkFactory();
        DoWorkResult result = multiReasonThing.doWork("something", handler);

        result.doSideEffect(new PrintSideEffects());
    }

    @Test
    public void minimalAbstraction() {
        MultiReasonThing multiReasonThing = new MultiReasonThing();

        DoWorkResult result = multiReasonThing.minimalAbstractionDoWork("Visa card number"); // This version does not take a handler

        result.doSideEffect(new PrintSideEffects());

        // May not need mapping functionality, but it can be added
        String formattedResultString = result.mapResult(new StringResultMapper()); // rather than a StringResultMapper, there could be an HTTPResultMapper

        System.out.println(formattedResultString);
    }
}