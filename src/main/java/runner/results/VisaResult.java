package runner.results;

import core.DoWorkResult;
import core.ResultMapper;
import core.SideEffects;

public class VisaResult implements DoWorkResult {

    private String token;

    public VisaResult(String token) {
        this.token = token;
    }

    @Override
    public void doSideEffect(SideEffects sideEffects) {
        sideEffects.visaSideEffects(token);
    }

    @Override
    public <T> T mapResult(ResultMapper<T> mapper) {
        return mapper.mapVisa(token);
    }
}
