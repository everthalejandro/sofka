# language: es
@Validar
Característica: Validar swagger
  Yo como usuario deseo realizar las pruebas a los servicios swagger

  @CRUD
  Esquema del escenario: Hacer crud dentro del swagger
    Dado se envian los datos <username>, <firstName>, <lastName>, <email>
    Y se obtiene code "200"
    Cuando se busca el valor del registro creado
    Y se obtiene code "200"
    Y se editan los datos <set> del registro buscado por <values>
    Y se obtiene code "200"
    Entonces se elimina el registro creado buscado y actualizado anteriormente
    Y se obtiene code "200"
    Ejemplos:
      | username | firstName | lastName          | email                       | set               | values                                      |
      | "SOFKA1" | "TEST1"   | "AUTOMATIZACIÓN1" | "AUTOMATIZACION1@gmail.com" | "username, email" | "SKILL1, SKILLAUTOMATIZACION1@hotmmail.com" |
      | "SOFKA2" | "TEST2"   | "AUTOMATIZACIÓN2" | "AUTOMATIZACION2@gmail.com" | "username, email" | "SKILL2, SKILLAUTOMATIZACION2@hotmmail.com" |
      | "SOFKA3" | "TEST3"   | "AUTOMATIZACIÓN3" | "AUTOMATIZACION3@gmail.com" | "username, email" | "SKILL3, SKILLAUTOMATIZACION3@hotmmail.com" |