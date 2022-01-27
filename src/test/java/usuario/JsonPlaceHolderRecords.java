package usuario;

import com.google.gson.Gson;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;
import org.json.XML;


@JsonIgnoreProperties(ignoreUnknown = true)

public record JsonPlaceHolderRecords(Integer id, String name, String username, String email,
                                     String street, String suite, String city, String zipcode,
                                     String companyName, String lat, String lng, String phone,
                                     String website, String catchphrase, String bs) {
    public JSONObject getJson() {

        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml() {

        return XML.toString(getJson());
    }
}
