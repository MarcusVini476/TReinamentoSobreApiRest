package apis;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {

    Map<String, String> headers = new HashMap<>();

    public Map<String, String> jsonPlasceHolderHeader(){
        headers.put("accept","*/*");
        headers.put("Content-Type","application/json");
        return headers;
    }

    public Map<String, String> SwaggerPetsHeaders() {
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
        return headers;
    }

}
