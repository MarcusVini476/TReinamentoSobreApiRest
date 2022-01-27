package passos;

import apis.ApiHeaders;
import apis.ApiParams;
import apis.ApiRequest;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import usuario.UsuarioLombokPet;
import utils.UtilsProperties;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PassosSwaggerPetStoreUsuarios extends ApiRequest {
    String nomeParaTestes = "NovoUsuarioParaTestes";
    UtilsProperties prop = new UtilsProperties();
    ApiHeaders apiHeaders = new ApiHeaders();
    ApiParams apiParams = new ApiParams();
    UsuarioLombokPet usuarioEnvio;
    Faker faker = new Faker();

    //-----------------inicio--------------------
    @Dado("que possuo uma chave para acessar a Swagger")
    public void quePossuoUmaChaveParaAcessarASwagger() {
        System.out.println("Esta API não esta usando chaves de acesso no momento!!!");
    }

    //---------------POST-----------------------------------------------
    //---------------@PostSwaggerUsuario---------------------------------------------------
    @Quando("realizo a criação de um usuario")
    public void realizoACriaçãoDeUmUsuario() {

        super.uri = prop.getProp("uri_petstore_user");
        super.headers = apiHeaders.SwaggerPetsHeaders();
        //--nesta Api o Id permanece 1
        usuarioEnvio = UsuarioLombokPet.builder()
                .id(faker.idNumber().hashCode())
                .username(nomeParaTestes)
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .phone(faker.phoneNumber().cellPhone())
                .userStatus(0)
                .build();

        super.body = new JSONObject(new Gson().toJson(usuarioEnvio));
        super.POST();


    }

    @Então("a criação tem de ser um sucesso")
    public void aCriaçãoTemDeSerUmSucesso() {
        assertEquals(usuarioEnvio.getId().toString(), response.jsonPath().getString("message"), "não é compativel");


    }

    //----------------------Comprova a existencia de um usuario--------------------

    @E("existe um usuario ja cadastrado na API")
    public void existeUmUsuarioJaCadastradoNaAPI() {
        realizoACriaçãoDeUmUsuario();
    }


    //-----------------------------PUT----------------------------------
    //-----------------------------@PutSwaggerUsuario-------------------------------------

    @Quando("realizar a alteração de Nome do Usuario")
    public void realizarAAlteraçãoDeNomeDoUsuario() {
        super.uri = prop.getProp("uri_petstore_user") + "/" + usuarioEnvio.getUsername();
        super.headers = apiHeaders.SwaggerPetsHeaders();
        usuarioEnvio.setUsername("UsuarioYaman");
        super.body = new JSONObject(new Gson().toJson(usuarioEnvio));
        super.PUT();

    }

    @Então("a alteração deve ser sucedida")
    public void aAlteraçãoDeveSerSucedida() {

        assertEquals(usuarioEnvio.getId().toString(), response.jsonPath().getString("message"));
        assertEquals(usuarioEnvio.getUsername(), "UsuarioYaman");
    }

    //-----------------------Deletar------------------------------------
    //-----------------------@DeleteSwaggerUsuario-------------------------------------------
    @Quando("Deletear um usuario Usuario")
    public void deletearUmUsuarioUsuario() {
        realizoACriaçãoDeUmUsuario();
        super.uri = prop.getProp("uri_petstore_user") + "/" + usuarioEnvio.getUsername();
        super.headers = apiHeaders.SwaggerPetsHeaders();
        super.body = new JSONObject();
        super.DELETE();

    }

    @Então("usuario deve ser deletado com sucesso")
    public void usuarioDeveSerDeletadoComSucesso() {
        System.out.println(response.asString());
    }


    //-----------------------Puxar login de usuario GET-----------------
    //-----------------------@GetSwaggerLogin---------------------------
    @Quando("realizar a busca de Login do usuario")
    public void realizarABuscaDeLoginDoUsuario() {
        super.uri = prop.getProp("uri_petstore_login");
        super.params = apiParams.loginSwagger();
        super.GET();


    }

    @Então("a busca deve ser um sucesso exibindo code {string} no payload")
    public void aBuscaDeveSerUmSucessoExibindoCodeNoPayload(String codeEsperado) {
        assertEquals(codeEsperado, response.jsonPath().getString("code"));
    }


    //-----------------------Puxar logout de usuario GET-----------------
    //-----------------------@GetSwaggerLogout---------------------------
    @Quando("realizar a busca do logout do usuario")
    public void realizarABuscaDoLogoutDoUsuario() {
        super.uri = prop.getProp("uri_petstore_logout");
        super.params = apiParams.logoutSwagger();
        super.GET();
    }

    @Então("a busca deve ser um sucesso exibindo code {string}  e message {string} no payload")
    public void aBuscaDeveSerUmSucessoExibindoCodeEMessageNoPayload(String codeEsperado, String messageEperada) {
        assertEquals(codeEsperado, response.jsonPath().getString("code"));
        assertEquals(messageEperada, response.jsonPath().getString("message"));
    }


    //----------------------validação de status-------------------------
    @Então("devolver status {int}")
    public void devolverStatus(int StatusEsperado) {
        assertEquals(StatusEsperado, response.statusCode());

    }


}
