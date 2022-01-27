package usuario;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.Objects;

public class JsonPlaceHolderConstructor {
    private Integer id;
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

    public JsonPlaceHolderConstructor(Integer id, String name,
                                      String username, String email,
                                      String street, String suite,
                                      String city, String zipcode, String companyName,
                                      String lat, String lng, String phone, String website,
                                      String catchphrase, String bs) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.companyName = companyName;
        this.lat = lat;
        this.lng = lng;
        this.phone = phone;
        this.website = website;
        this.catchphrase = catchphrase;
        this.bs = bs;
    }

    public JSONObject getJson(){
        return new JSONObject(new Gson().toJson(this));
    }

    @Override
    public boolean equals(Object o){
        if(this==o)return  true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonPlaceHolderConstructor that = (JsonPlaceHolderConstructor) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(username, that.username)
                && Objects.equals(email, that.email)
                && Objects.equals(street, that.street)
                && Objects.equals(suite, that.suite)
                && Objects.equals(city, that.city)
                && Objects.equals(zipcode, that.zipcode)
                && Objects.equals(companyName, that.companyName)
                && Objects.equals(lat, that.lat)
                && Objects.equals(lng, that.lng)
                && Objects.equals(phone, that.phone)
                && Objects.equals(website, that.website)
                && Objects.equals(catchphrase, that.catchphrase)
                && Objects.equals(bs, that.bs);
    }



}
