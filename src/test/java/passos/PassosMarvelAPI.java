package passos;


import apis.ApiParams;
import apis.ApiRequest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import org.json.JSONObject;
import utils.UtilsProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassosMarvelAPI extends ApiRequest {
    UtilsProperties prop = new UtilsProperties();

    ApiParams apiParams = new ApiParams();

    //----------------------inicio-------------------------------------
    @Dado("que possuo uma chave de acesso a MarvelApi")
    public void quePossuoUmaChaveDeAcessoAMarvelApi() {
        token = prop.getProp("token_marvel_public_key");

    }
    //----------------------GET---------------------------------------
    //----------------------@GetGabrielLan----------------------------

    @Dado("envio um request válido do ID de numero {int}")
    public void envioUmRequestVálidoDoIDDeNumero(int IdDeHeroi) {
        super.uri = prop.getProp("uri_marvel_char") + "/" + IdDeHeroi;
        super.params = apiParams.MarvelHero(token);

        super.body = new JSONObject();
        super.GET();
    }

    @Então("o heroi procurado deve ser {string}")
    public void oHeroiProcuradoDeveSer(String nomeDoHeroi) {
        System.out.println("---Asserts---");
        assertEquals("[" + nomeDoHeroi + "]", response.jsonPath().getString("data.results.name"));
    }


    //--------------------métodos com Esquemas-----------------------
    //--------------------Get----------------------------------------
    //--------------------@GetHeroesCenario--------------------------

    @E("envio um request com {string} válido")
    public void envioUmRequestComVálido(String IdHeroi) {
        super.uri = prop.getProp("uri_marvel_char") + "/" + IdHeroi;
        super.params = apiParams.MarvelHero(token);
        super.body = new JSONObject();
        super.GET();
    }

    @Então("o {string} procurado deve ser válido")
    public void oProcuradoDeveSerVálido(String heroi) {
        assertEquals("[" + heroi + "]", response.jsonPath().getString("data.results.name"));
    }

    //----------------------------caminhos tristes-----------------------------
    //------------------@GetHeroesCenario caminho triste--------------------------
    @E("envio um request com {string} inválido")
    public void envioUmRequestComInválido(String idInvalido) {
        super.uri = prop.getProp("uri_marvel_char") + "/" + idInvalido;
        super.params = apiParams.MarvelHero(token);
        super.body = new JSONObject();
        super.GET();
    }

    @Então("o heroi procurado deve ser inválido e deve validar a {string}")
    public void oHeroiProcuradoDeveSerInválidoEDeveValidarA(String mensagem) {
        assertEquals(mensagem, response.jsonPath().getString("status"));
    }

    //------------------validação de status code-----------------------------------------
    @Então("o status code deve me retornar o valor {int}")
    public void oStatusCodeDeveMeRetornarOValor(Integer codeEsperado) {
        assertEquals(codeEsperado, response.statusCode());
    }


}
