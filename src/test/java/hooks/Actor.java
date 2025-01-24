package hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Actor {
    @Before
    public void setUpOneStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario SauceLabs");
    }
}