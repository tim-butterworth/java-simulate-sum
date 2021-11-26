package runner.mapper;

import core.ResultMapper;

public class StringResultMapper implements ResultMapper<String> {

    @Override
    public String mapVisa(String token) {
        return "Specially formatted visa response -> " + token;
    }

    @Override
    public String mapApple(String token) {
        return "Specially formatted apple response -> " + token;
    }

    @Override
    public String mapMasterCard(String token) {
        return "Specially formatted master card response -> " + token;
    }

    @Override
    public String mapRejection(String reason) {
        return "This was rejected :( -> " + reason;
    }
}
