package General;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.Collections;
import java.util.Objects;

import static java.time.Duration.ZERO;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.Kind.MOUSE;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class AndroidDriver {
    private static final Logger LOGGER = LoggerFactory.getLogger(AndroidDriver.class);
    public static io.appium.java_client.AppiumDriver driver = getUnderlyingAndroidDriver();
    public static io.appium.java_client.android.AndroidDriver getUnderlyingAndroidDriver(){
        LOGGER.info("Solicitando Driver");
        return (io.appium.java_client.android.AndroidDriver)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
    public static void scroll2(String pageDirection, double scrollRatio){
        Duration SCROLL_DUR = Duration.ofMillis(300);
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll Ratio must be between 0 and 1");
        }
        Dimension size = getUnderlyingAndroidDriver().manage().window().getSize();
        System.out.println("Screen Size = "+size);
        Point midPoint = new Point((int)(size.width * 0.5),(int)(size.height * 0.5));
        int bottom = midPoint.y + (int)(midPoint.y * scrollRatio);
        int top = midPoint.y - (int)(midPoint.y * scrollRatio);
        int left = midPoint.x - (int)(midPoint.x * scrollRatio);
        int right = midPoint.x + (int)(midPoint.x * scrollRatio);
        if (Objects.equals(pageDirection, "UP")) {
            swipe2(new Point(midPoint.x, top), new Point(midPoint.x, midPoint.y), SCROLL_DUR);
        } else if (Objects.equals(pageDirection, "DOWN")) {
            swipe2(new Point(midPoint.x, midPoint.y), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (Objects.equals(pageDirection, "LEFT")) {
            swipe2(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            swipe2(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }
    protected static void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(TOUCH, "finger");
        Sequence sequence = new Sequence(input, 0);
        sequence.addAction(input.createPointerMove(ZERO, viewport(), start.x, start.y));
        sequence.addAction(input.createPointerDown(LEFT.asArg()));
        sequence.addAction(input.createPointerMove(duration, viewport(), end.x, end.y));
        sequence.addAction(input.createPointerUp(LEFT.asArg()));
        driver.perform(ImmutableList.of(sequence));
    }
    protected static void swipe2(Point start, Point end, Duration duration) {
        PointerInput finger1 = new PointerInput(TOUCH, "Finger1");
        Sequence sequence = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(ZERO, viewport(), start.x, start.y))
                .addAction(finger1.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(300)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), viewport(), end.x, end.y))
                .addAction(finger1.createPointerUp(LEFT.asArg()));
        getUnderlyingAndroidDriver().perform(Collections.singletonList(sequence));
    }
    public static void pressPoint(double xRatio, double yRatio){
        Dimension size = getUnderlyingAndroidDriver().manage().window().getSize();
        System.out.println("Screen Size = "+size);
        Point midTopPoint = new Point((int)(size.width * xRatio),(int)(size.height * yRatio));
        System.out.println("X = "+midTopPoint.x);
        System.out.println("Y = "+midTopPoint.y);

        PointerInput finger1 = new PointerInput(MOUSE, "Finger1");
        Sequence sequence = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(ZERO, viewport(), midTopPoint.x, midTopPoint.y))
                .addAction(finger1.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(300)))
                .addAction(finger1.createPointerUp(LEFT.asArg()));
        getUnderlyingAndroidDriver().perform(Collections.singletonList(sequence));

    }
    public static void scrollToElement(Target element, int scrolls, double scrollRatio) throws InterruptedException {
        int scroll = 0;
        LOGGER.info("Scrolling to Element: {}", element.getName());
        LOGGER.info("IS VISIBLE: {}", element.isVisibleFor(theActorInTheSpotlight()));
        Thread.sleep(1000);
        while (!element.waitingForNoMoreThan(Duration.ofSeconds(5L)).isVisibleFor(theActorInTheSpotlight()) ) {
            AndroidDriver.scroll2("DOWN", scrollRatio);
            if (scroll >= scrolls) break;
            scroll++;
        }
        if (AndroidDriver.isTargetVisibleForUser(element)){
            AndroidDriver.scroll2("DOWN", 0.5);
        }
    }
    public static boolean isTargetVisibleForUser(Target element){
        Dimension size = getUnderlyingAndroidDriver().manage().window().getSize();
        WebElement elemento = element.resolveFor(theActorInTheSpotlight()).getElement();
        LOGGER.info("Element Location: {}", elemento.getLocation());
        boolean isVisible = elemento.getLocation().getY() < size.height * 0.8;
        LOGGER.info("Element is Visible: {}", isVisible);
//        return !(elemento.getLocation().getY() < size.height * 0.8);
        return !isVisible;
    }

}