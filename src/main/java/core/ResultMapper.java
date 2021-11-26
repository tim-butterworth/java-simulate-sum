package core;

public interface ResultMapper<T> {
    T mapVisa(String token);
    T mapApple(String token);
    T mapMasterCard(String token);
    T mapRejection(String reason);
}
