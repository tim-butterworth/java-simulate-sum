package runner.results;

import core.DoWorkResult;
import core.ResultMapper;
import core.SideEffects;

public class AppleCardResult implements DoWorkResult {
    private String token;

    public AppleCardResult(String token) {
        this.token = token;
    }

    @Override
    public void doSideEffect(SideEffects sideEffects) {
        sideEffects.appleCardSideEffects(token);
    }

    @Override
    public <T> T mapResult(ResultMapper<T> mapper) {
        return mapper.mapApple(token);
    }
}
