package Tasks;

import General.AndroidDriver;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyProductTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuyProductTasks.class);
    public static Performable loadFile(String path) {
        return Task.where(
                "{0} carga el archivo de datos " + path,
                actor -> {
                    StringBuilder content = new StringBuilder();

                    try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+path))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            content.append(line);
                        }

                        // Convertir el contenido a un JSONObject
                        JSONObject json = new JSONObject(content.toString());

                        // Acceder a los datos
                        theActorInTheSpotlight().remember("Json", json);
                        //imprimir los datos en logger
                        LOGGER.info("Datos del archivo: " + json.toString());
                    } catch (IOException e) {
                        LOGGER.info("Error al leer el archivo: ", e);
                    }
                }
        );
    }

    public static Performable addBackpackToCart() {
        return Task.where(
                "{0} agrega una mochila a su carrito",
                actor -> {
                    JSONObject jsonObject = actor.recall("Json");
                    theActorInTheSpotlight().attemptsTo(
                            Click.on(Ui.SauceLabsPage.ObjectToBuy),
                            Click.on(Ui.SauceLabsPage.AddToCartButton),
                            Click.on(Ui.SauceLabsPage.CartButton),
                            Click.on(Ui.SauceLabsPage.CheckoutButton)
                    );
                }
        );
    }

    public static Performable finishPurchase() {
        return Task.where(
                "{0} realiza la compra llenando el formulario",
                actor -> {
                    JSONObject jsonObject = actor.recall("Json");
                    theActorInTheSpotlight().attemptsTo(
                            SendKeys.of(jsonObject.get("User").toString()).into(Ui.SauceLabsPage.Username),
                            SendKeys.of(jsonObject.get("Password").toString()).into(Ui.SauceLabsPage.Password),
                            Click.on(Ui.SauceLabsPage.LoginButton),
                            SendKeys.of(jsonObject.get("FullName").toString()).into(Ui.SauceLabsPage.FullName.waitingForNoMoreThan(Duration.ofSeconds(1000L))),
                            SendKeys.of(jsonObject.getString("AddressLine1")).into(Ui.SauceLabsPage.AddressLine1),
                            SendKeys.of(jsonObject.getString("AddressLine2")).into(Ui.SauceLabsPage.AddressLine2),
                            SendKeys.of(jsonObject.getString("City")).into(Ui.SauceLabsPage.City),
                            SendKeys.of(jsonObject.getString("State")).into(Ui.SauceLabsPage.State),
                            SendKeys.of(jsonObject.getString("ZipCode")).into(Ui.SauceLabsPage.ZipCode),
                            SendKeys.of(jsonObject.getString("Country")).into(Ui.SauceLabsPage.Country),
                            Click.on(Ui.SauceLabsPage.ToPaymentButton),
                            SendKeys.of(jsonObject.getString("FullName")).into(Ui.SauceLabsPage.CardholderName),
                            SendKeys.of(jsonObject.getString("CardNumber")).into(Ui.SauceLabsPage.CardNumber),
                            SendKeys.of(jsonObject.getString("CardExpiration")).into(Ui.SauceLabsPage.ExpirationDate),
                            SendKeys.of(jsonObject.getString("CardCVV")).into(Ui.SauceLabsPage.CVV),
                            Click.on(Ui.SauceLabsPage.ReviewOrderButton),
                            Click.on(Ui.SauceLabsPage.ConfirmOrderButton)
                    );
                }
        );
    }
}