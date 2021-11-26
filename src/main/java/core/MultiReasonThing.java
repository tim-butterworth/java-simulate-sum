package core;

import runner.results.AppleCardResult;
import runner.results.MasterCardResult;
import runner.results.RejectHandler;
import runner.results.VisaResult;

public class MultiReasonThing {
    // This is probably the most error prone approach, nothing prevents more than one of the handler methods from being called or hints that maybe only one method should be called, the handler could throw an exception internally or something... but that is yuck
    public void voidDoWork(String cardNumber, VoidDoWorkHandler handler) {
        if (isValidVisa(cardNumber)) {
            handler.acceptedVisa(generateVisaToken());
        }
        if (isValidMasterCard(cardNumber)) {
            handler.acceptedMasterCard(generateMasterCardToken());
        } else if (isValidAppleCard(cardNumber)) {
            handler.acceptedAppleCard(generateAppleCardToken());
        } else {
            handler.rejected("Was not a supported card");
        }
    }

    public DoWorkResult doWork(String cardNumber, ResultDoWorkHandler handler) {
        if (isValidAppleCard(cardNumber)) {
            return handler.acceptedAppleCard(generateAppleCardToken());
        }

        if (isValidVisa(cardNumber)) {
            return handler.acceptedVisa(generateVisaToken());
        }

        if (isValidMasterCard(cardNumber)) {
            return handler.acceptedMasterCard(generateMasterCardToken());
        }

        return handler.rejected("Was not a supported card", ErrorTypes.FOUR);
    }

    public DoWorkResult minimalAbstractionDoWork(String cardNumber) {
        if (isValidAppleCard(cardNumber)) {
            return new AppleCardResult(generateAppleCardToken());
        }

        if (isValidVisa(cardNumber)) {
            return new VisaResult(generateVisaToken());
        }

        if (isValidMasterCard(cardNumber)) {
            return new MasterCardResult(generateMasterCardToken());
        }

        return new RejectHandler("Was not a supported card", ErrorTypes.TWO);
    }

    private String generateAppleCardToken() {
        return "Apple Token";
    }
    private String generateMasterCardToken() {
        return "Master Card Token";
    }
    private String generateVisaToken() {
        return "Visa Token";
    }

    private boolean isValidAppleCard(String cardNumber) {
        return cardNumber != null && cardNumber.contains("Apple");
    }
    private boolean isValidMasterCard(String cardNumber) {
        return cardNumber != null && cardNumber.contains("MasterCard");
    }
    private boolean isValidVisa(String cardNumber) {
        return cardNumber != null && cardNumber.contains("Visa");
    }
}
