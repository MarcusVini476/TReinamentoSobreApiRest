package usuario;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;
import org.json.XML;

@Data
@Builder
public class UsuarioLombokPet {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public JSONObject getJson() {

        return new JSONObject(new Gson().toJson(this));
    }

    public String getXml() {

        return XML.toString(getJson());
    }
}
