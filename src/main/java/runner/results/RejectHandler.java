package runner.results;

import core.DoWorkResult;
import core.ErrorTypes;
import core.ResultMapper;
import core.SideEffects;

public class RejectHandler implements DoWorkResult {
    private String reason;
    private ErrorTypes errorType;

    public RejectHandler(String reason, ErrorTypes errorType) {
        this.reason = reason;
        this.errorType = errorType;
    }

    @Override
    public void doSideEffect(SideEffects sideEffects) {
        sideEffects.invalidSideEffects(reason, errorType);
    }

    @Override
    public <T> T mapResult(ResultMapper<T> mapper) {
        return mapper.mapRejection(reason);
    }
}
