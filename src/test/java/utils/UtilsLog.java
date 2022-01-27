package utils;

public class UtilsLog {
    public void logInfo(String value){
        if(!value.contains("{}")){
            UtilsCenario.addText(value);
        }

    }

    public void logError(String value){
        if(!value.contains("{}")){
            UtilsCenario.addText(value);
        }

    }

}
