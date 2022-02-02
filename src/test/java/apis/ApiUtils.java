package apis;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.UtilsLog;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApiUtils extends UtilsLog {
    protected static Response response;
    protected static JSONObject body;
    protected static String uri;
    protected static Map<String, String> headers =new HashMap<>();
    protected static Map<String, String> params =new HashMap<>();
    protected static String token;

    public void log (String verbo){
        super.logInfo("***Dados enviados no request***");
        super.logInfo(verbo + " " + uri);
        super.logInfo("Body : \n" + body);
        super.logInfo("Headers : " +  headers);
        super.logInfo("Params : " + params);


        super.logInfo("***Dados Recebidos**");
        super.logInfo("Status Code : " + response.statusCode());
        super.logInfo("Payload recebido : \n" + response.asPrettyString());
        super.logInfo("Tempo de Resposta : " + response.timeIn(TimeUnit.MILLISECONDS));
        super.logInfo("Tamanho do Corpo : " + response.body().jsonPath().getJsonObject("size()") + " objetos");

    }


}
