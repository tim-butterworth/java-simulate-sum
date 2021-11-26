package core;

public interface VoidDoWorkHandler {
    void acceptedVisa(String token);
    void acceptedMasterCard(String token);
    void acceptedAppleCard(String token);
    void rejected(String reason);
}
