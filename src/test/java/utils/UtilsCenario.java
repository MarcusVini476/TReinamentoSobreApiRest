package utils;

import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class UtilsCenario {

    private static Map<Long, Scenario> repository = new HashMap<>();

    /*realiza um put dentro do cenario*/
    public static void add(Scenario scenario) {
        if (get() == null) {
            repository.put(getId(), scenario);
        }

    }

    /*ao finalizar o cenario, remove*/
    public static void remove() {
        if (get() != null) {
            repository.remove(getId());
        }
    }

    /*captura o id do cenário*/
    public static Scenario get() {

        return repository.get(getId());
    }

    /*cria um Id unico para o log*/
    public static Long getId() {

        return Thread.currentThread().getId();
    }

    /*envia informações dentro do Log*/
    public static void addText(String texto) {

        get().log(texto);
    }


}
