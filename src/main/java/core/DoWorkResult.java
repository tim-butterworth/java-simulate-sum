package core;

public interface DoWorkResult {
    void doSideEffect(SideEffects sideEffects);
    <T> T mapResult(ResultMapper<T> mapper);
}
