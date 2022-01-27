package usuario;

import com.google.gson.Gson;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;
import org.json.XML;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class JsonPlaceHolderLombok {
    @Builder.Default
    private Integer id = 11;
    private String name;
    private String username;
    private String email;

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private String companyName;
    private String lat;
    private String lng;
    private String phone;
    private String website;

    private String catchphrase;
    private String bs;


    public JSONObject getJson() {

        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml() {

        return XML.toString(getJson());
    }
}
