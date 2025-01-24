Feature: Compra primer producto de la tienda

  Scenario: Compra de un producto en sauceLabsApp
    #por defecto se ejecuta la aplicacion al inicio por lo que no se requiere un paso para abrir la aplicacion
    Given el usuario carga el archivo de datos "/src/test/resources/datos.json"
    When el usuario agrega un producto a su carrito
    And el usuario realiza la compra llenando el formulario
    Then el usuario debería ver el mensaje de confirmación de compra "Checkout Complete"