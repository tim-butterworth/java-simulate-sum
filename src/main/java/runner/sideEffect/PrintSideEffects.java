package runner.sideEffect;

import core.ErrorTypes;

// This object would need to have any db or service dependencies injected probably
public class PrintSideEffects implements core.SideEffects {
    @Override
    public void visaSideEffects(String token) {
        System.out.println("Visa -> " + token);
    }

    @Override
    public void masterCardSideEffects(String token) {
        System.out.println("Master Card -> " + token);
    }

    @Override
    public void appleCardSideEffects(String token) {
        System.out.println("Apple Card -> " + token);
    }

    @Override
    public void invalidSideEffects(String errorMessage, ErrorTypes errorType) {
        System.out.println("Invalid -> " + errorMessage + " type -> " + errorType.name());
    }
}
