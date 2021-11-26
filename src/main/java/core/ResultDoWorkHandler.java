package core;

public interface ResultDoWorkHandler {
    DoWorkResult acceptedVisa(String token);
    DoWorkResult acceptedMasterCard(String token);
    DoWorkResult acceptedAppleCard(String token);
    DoWorkResult rejected(String reason, ErrorTypes errorType);
}
