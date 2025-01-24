package Ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class SauceLabsPage {
    public static Target ObjectToBuy = Target.the("Object to Buy").located(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)"));
    public static Target AddToCartButton = Target.the("Add to Cart").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt"));
    public static Target CartButton = Target.the("Cart").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV"));
    public static Target CheckoutButton = Target.the("Checkout").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartBt"));

    //username and password
    public static Target Username = Target.the("Username").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET"));
    public static Target Password = Target.the("Password").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET"));
    public static Target LoginButton = Target.the("Login").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn"));

    //checkout form
    public static Target FullName = Target.the("Full Name").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/fullNameET"));
    public static Target AddressLine1 = Target.the("Address Line 1").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/address1ET"));
    public static Target AddressLine2 = Target.the("Address Line 2").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/address2ET"));
    public static Target City = Target.the("City").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cityET"));
    public static Target State = Target.the("State").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/stateET"));
    public static Target ZipCode = Target.the("Zip Code").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/zipET"));
    public static Target Country = Target.the("Country").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/countryET"));

    //Payment
    public static Target ToPaymentButton = Target.the("To Payment").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn"));
    public static Target CardholderName = Target.the("Cardholder Name").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET"));
    public static Target CardNumber = Target.the("Card Number").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/cardNumberET"));
    public static Target ExpirationDate = Target.the("Expiration Date").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/expirationDateET"));
    public static Target CVV = Target.the("CVV").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/securityCodeET"));
    public static Target ReviewOrderButton = Target.the("Review Order").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn"));
    public static Target ConfirmOrderButton = Target.the("Confirm Order").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn"));

    public static Target ConfirmationMessage = Target.the("Confirmation Message").located(AppiumBy.id("com.saucelabs.mydemoapp.android:id/completeTV"));

}