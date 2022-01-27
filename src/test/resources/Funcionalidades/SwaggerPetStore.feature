#language: pt
#Author: Marcus
#Version: 1.0
#Encoding: UTF-8


@Regressivo @SwaggerUserCUD
Funcionalidade: Criar e editar informações sobre pets na PetStore
  Eu como administrador, quero cadastrar, editar e excluir Pets do Sistema

  @PostSwaggerUsuario
  Cenario: criando um usuario no sistema
    Dado que possuo uma chave para acessar a Swagger
    Quando realizo a criação de um usuario
    Então a criação tem de ser um sucesso
    E devolver status 200




  @PutSwaggerUsuario
  Cenario: Alterar informação de um usuario existente no sistema
    Dado que possuo uma chave para acessar a Swagger
    E existe um usuario ja cadastrado na API
    Quando realizar a alteração de Nome do Usuario
    Então a alteração deve ser sucedida
    E devolver status 200



  @DeleteSwaggerUsuario
  Cenario: Deletar as informações de um usuario existente no sistema
    Dado que possuo uma chave para acessar a Swagger
    E existe um usuario ja cadastrado na API
    Quando Deletear um usuario Usuario
    Então usuario deve ser deletado com sucesso
    E devolver status 200




  @GetSwaggerLogin
  Cenario: Puxar o login de um usuario no sistema
    Dado que possuo uma chave para acessar a Swagger
    Quando realizar a busca de Login do usuario
    Então a busca deve ser um sucesso exibindo code "200" no payload
    E devolver status 200


  @GetSwaggerLogout
  Cenario: Puxar o logout de um usuario no sistema
    Dado que possuo uma chave para acessar a Swagger
    Quando realizar a busca do logout do usuario
    Então a busca deve ser um sucesso exibindo code "200"  e message "ok" no payload
    E devolver status 200





