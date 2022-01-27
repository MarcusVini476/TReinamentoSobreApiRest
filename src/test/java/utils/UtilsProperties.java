package utils;

import java.io.IOException;
import java.util.Properties;

public class UtilsProperties {
    Properties properties = new Properties();
    String propAmbiente = "hom";

    public String getProp(String Chave){
        try{
            if(System.getProperty("env")== null){
                properties.load(getClass().getClassLoader().getResourceAsStream(propAmbiente+".properties"));
            }else{
                properties.load(getClass().getClassLoader().getResourceAsStream("env"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(Chave);
    }

}
