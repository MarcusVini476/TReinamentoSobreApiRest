#language: pt
#Author: Marcus
#Version: 1.0
#Encoding: UTF-8



@Regressivo @JPHApi
Funcionalidade: Realizar e validar testes Rest com a Api da Json Place Holder

#lombok
  @PostUsuarioLombokApi
  Cenário: Realizar a criação de Usuario  utilizado lombok
    Dado que tenho acesso a JsonPlaceHolder
    Quando enviar uma requisiçao com dados validos
    Então devo validar do corpo recebido e o corpo enviado
    E garantir a devolutiva de status 201

  @GetUsuarioLombokApi
  Esquema do Cenário: Realizar buscas de 10 usuarios na Api
    Dado  que tenho acesso a JsonPlaceHolder
    Quando realizar buscas de "<usuarios>"
    Então devo validar do corpo recebido, os "<nomesUsuarios>"
    E garantir a devolutiva de status 200
    Exemplos:
      | usuarios | nomesUsuarios      |
      | 1        | Leanne Graham      |
      | 2        | Ervin Howell       |
      | 9        | Glenna Reichert    |
      | 10       | Clementina DuBuque |

  @PutUsuarioLombokApi
  Esquema do Cenário: Realizar atualização de nome de 4 usuarios na Api
    Dado  que tenho acesso a JsonPlaceHolder
    E tenho um usuario criado
    Quando realizar buscas de "<usuarios>" e altera seu respectivos "<nomesUsuarios>"
    Então devo validar do corpo recebido, os "<nomesUsuarios>" alterados
    E garantir a devolutiva de status 200
    Exemplos:
      | usuarios | nomesUsuarios |
      | 1        | Leanne        |
      | 2        | Ervin         |
      | 9        | Glenna        |
      | 10       | Clementina    |


  @PatchUsuarioLombokApi
  Esquema do Cenário: Mudar o nome da companhia
    Dado que tenho acesso a JsonPlaceHolder
    E tenho um usuario criado
    Quando Alterar o nome da companhia para "<nomeEmpresa>" do "<usuario>"
    Então devo validar se o "<nomeEmpresa>" foi trocado
    E garantir a devolutiva de status 200
    Exemplos:
      | usuario | nomeEmpresa      |
      | 1       | yaman Industries |
      | 2       | DEX AMR          |
      | 9       | yaman Industries |
      | 10      | DEX AMR          |

  @DeleteUsuarioLombokApi
  Esquema do Cenário: Deletar um Usuario da Api
    Dado que tenho acesso a JsonPlaceHolder
    E tenho um usuario criado
    Quando deletar um "<usuario>"
    Então devo validar o corpo do delete
    E garantir a devolutiva de status 200
    Exemplos:
      | usuario |
      | 1       |
      | 2       |
      | 9       |
      | 10      |



#constructor
  @PostUsuarioConstructor
  Cenário: Criar um usuario na Api usando constructor
    Dado que tenho acesso a JsonPlaceHolder
    E envio dados validos de um usuario usando um constructor
    Então devo validar do corpo recebido e o corpo enviado
    E garantir a devolutiva de status 201

#GettersEsetters
  @PostUsuarioGetterSetters
  Cenário: criar um usuario na Api usando get e set
    Dado que tenho acesso a JsonPlaceHolder
    E envio dados validos de um usuario usando get e set
    Então devo validar do corpo recebido e o corpo enviado
    E garantir a devolutiva de status 201
#jsonPuro
#xml

