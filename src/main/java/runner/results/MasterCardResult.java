package runner.results;

import core.DoWorkResult;
import core.ResultMapper;
import core.SideEffects;

public class MasterCardResult implements DoWorkResult {
    private String token;

    public MasterCardResult(String token) {
        this.token = token;
    }

    @Override
    public void doSideEffect(SideEffects sideEffects) {
        sideEffects.masterCardSideEffects(token);
    }

    @Override
    public <T> T mapResult(ResultMapper<T> mapper) {
        return mapper.mapMasterCard(token);
    }
}
