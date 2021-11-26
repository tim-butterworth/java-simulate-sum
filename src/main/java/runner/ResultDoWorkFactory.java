package runner;

import core.DoWorkResult;
import core.ErrorTypes;
import core.ResultDoWorkHandler;
import runner.results.AppleCardResult;
import runner.results.MasterCardResult;
import runner.results.RejectHandler;
import runner.results.VisaResult;

public class ResultDoWorkFactory implements ResultDoWorkHandler {
    @Override
    public DoWorkResult acceptedVisa(String token) {
        return new VisaResult(token);
    }

    @Override
    public DoWorkResult acceptedMasterCard(String token) {
        return new MasterCardResult(token);
    }

    @Override
    public DoWorkResult acceptedAppleCard(String token) {
        return new AppleCardResult(token);
    }

    @Override
    public DoWorkResult rejected(String reason, ErrorTypes errorType) {
        return new RejectHandler(reason, errorType);
    }
}
