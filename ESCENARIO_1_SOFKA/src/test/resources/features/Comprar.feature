# language: es
@Comprar
Característica: Realizar compra de dos productos
  Yo como usuario deseo realizar la compra de dos productos de tecnologia

  Antecedentes:
    Dado que se ingresa a la url

  Escenario: Realiza compra de productos
    Dado que se buscan los producto "HTC Touch HD, Samsung Galaxy Tab 10.1"
    Cuando se da click en "carrito"
    Y se da click en "checkout"
    Y se confirman datos de "invitado"
    Y se da click en "confirm order"
    Entonces se visualiza mensaje "Your order has been placed!"