package runner;

import core.VoidDoWorkHandler;

import java.util.Optional;

public class MutableVoidDoWorkHandler implements VoidDoWorkHandler {

    private Boolean wasVisa = false;
    private Boolean wasMasterCard = false;
    private Boolean wasAppleCard = false;
    private Boolean wasRejected = false;

    private Optional<String> maybeToken = Optional.empty();
    private Optional<String> rejectionReason = Optional.empty();

    @Override
    public void acceptedVisa(String token) {
        wasVisa = true;
        maybeToken = Optional.of(token);
    }

    @Override
    public void acceptedMasterCard(String token) {
        wasMasterCard = true;
        maybeToken = Optional.of(token);
    }

    @Override
    public void acceptedAppleCard(String token) {
        wasAppleCard = true;
        maybeToken = Optional.of(token);
    }

    @Override
    public void rejected(String reason) {
        wasRejected = true;
        rejectionReason = Optional.of(reason);
    }

    public boolean wasVisa() {
        return true;
    }
}
