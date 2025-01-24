package StepDefinitions;

import Questions.BuyCompletedQuestion;
import Tasks.BuyBackpackTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyBackpackStepDefinitions {
    //steps definitions
    @Given("el usuario carga el archivo de datos {string}")
    public void elUsuarioCargaElArchivoDeDatos(String string) {
        theActorInTheSpotlight().attemptsTo(
                BuyBackpackTasks.loadFile(string)
        );
    }
    @When("el usuario agrega un producto a su carrito")
    public void elUsuarioAgregaUnaMochilaASuCarrito() {
        theActorInTheSpotlight().attemptsTo(
                BuyBackpackTasks.addBackpackToCart()
        );
    }

    @And("el usuario realiza la compra llenando el formulario")
    public void elUsuarioRealizaLaCompraLlenandoElFormulario() {
        theActorInTheSpotlight().attemptsTo(
                BuyBackpackTasks.finishPurchase()
        );
    }

    @Then("el usuario debería ver el mensaje de confirmación de compra {string}")
    public void elUsuarioDeberiaVerElMensajeDeConfirmacionDeCompra(String message) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(BuyCompletedQuestion.confirmationMessage(message))
        );
    }
}
