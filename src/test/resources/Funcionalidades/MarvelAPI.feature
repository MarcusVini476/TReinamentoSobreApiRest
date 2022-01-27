#language: pt
#Author: Marcus
#Version: 1.0
#Encoding: UTF-8


@Regressivo @MarvelApi
Funcionalidade: Puxar informações na API da marvel
  Eu como administrador quero puxar informações de heróis contidas na API

  @GetGabrielLan
  Cenário:Puxar heroi e comparar informações da payload payload
    Dado que possuo uma chave de acesso a MarvelApi
    E envio um request válido do ID de numero 1011136
    Então o heroi procurado deve ser "Air-Walker (Gabriel Lan)"
    E o status code deve me retornar o valor 200


  @GetHeroesCenario
  Esquema do Cenário: Capturar 4 herois dentro da API da Marvel
    Dado que possuo uma chave de acesso a MarvelApi
    E envio um request com "<ID>" válido
    Então o <heroi> procurado deve ser válido
    E o status code deve me retornar o valor 200
    Exemplos:
      | ID      | heroi                      |
      | 1011136 | "Air-Walker (Gabriel Lan)" |
      | 1011334 | "3-D Man"                  |
      | 1011175 | "Aginar"                   |
      | 1017851 | "Aero (Aero)"              |


  @GetHeroesScenarioCaminhoTriste @CaminhoTriste
  Esquema do Cenário: Capturar 4 herois dentro da API da Marvel com IDs Invalidos
    Dado que possuo uma chave de acesso a MarvelApi
    E envio um request com "<ID>" inválido
    Então o heroi procurado deve ser inválido e deve validar a <mensagem>
    E o status code deve me retornar o valor 404
    Exemplos:
      | ID       | mensagem                           |
      | 10111363 | "We couldn't find that character"  |
      | 10113343 | "We couldn't find that character" |
      | 10111753 | "We couldn't find that character"  |
      | 10178513 | "We couldn't find that character"  |