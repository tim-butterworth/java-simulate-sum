package core;

public interface SideEffects {
    void visaSideEffects(String token);
    void masterCardSideEffects(String token);
    void appleCardSideEffects(String token);

    // Just to show, every one of these methods could have different number and types of arguments if needed
    void invalidSideEffects(String errorMessage, ErrorTypes errorType);
}
