Feature: MyStore

  Scenario: Iniciar Sesion
  Given usuario ingresa a la pagina de Mystore
  When usuario se loguea
  Then visualiza su nombre de usuario:Henry Jiménez

  Scenario: Realizar una compra
    Given usuario agrega un producto a su carrito
    When confirma el meto de pago bancario
    Then visualiza el mensaje de pago exitoso
