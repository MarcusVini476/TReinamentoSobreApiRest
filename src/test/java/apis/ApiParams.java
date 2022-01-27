package apis;

import java.util.HashMap;
import java.util.Map;

public class ApiParams {

    Map<String, String> params = new HashMap<>();
    public Map<String, String> MarvelHero(String token) {
        params.put("apikey", token);
        params.put("ts", "1640959847");
        params.put("hash", "048df994caffe80a208e079ae7cc401d");

        return params;
    }
    public Map<String, String> loginSwagger() {
        params.put("username", "petra");
        params.put("password", "Gurin234");

        return params;
    }

    public Map<String, String> logoutSwagger() {

        return params;
    }


}
