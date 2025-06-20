package hooks;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Actor {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        String actorName = "SauceLabsUser_" + Thread.currentThread().threadId();
        theActorCalled(actorName).can(BrowseTheWeb.with(new CustomAppiumDriver().newDriver()));
    }
//    @Managed
//    WebDriver driver;
//    @Before
//    public void setTheStage() {
//        OnStage.setTheStage(new OnlineCast());
//        OnStage.theActorCalled("SauceLabsUser").can(BrowseTheWeb.with(driver));
////        OnStage.theActorCalled("SauceLabsUser");
//    }
}