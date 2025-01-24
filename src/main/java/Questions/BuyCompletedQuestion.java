package Questions;

import Ui.SauceLabsPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.Assert;

public class BuyCompletedQuestion {
    //questions
    public static Question<Boolean> confirmationMessage(String message) {
        return actor -> {
            String actualMessage = SauceLabsPage.ConfirmationMessage.resolveFor(actor).getText();
            Assert.assertEquals("El mensaje de confirmación no coincide", message, actualMessage);
            return true;
        };
    }
}
