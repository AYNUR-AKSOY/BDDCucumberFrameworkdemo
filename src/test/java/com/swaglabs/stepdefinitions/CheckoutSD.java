package com.swaglabs.stepdefinitions;

import com.swaglabs.base.ConfigReader;
import com.swaglabs.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSD {


    @Given("^user is logged in the shopping area$")
    public void userIsLoggedInTheShoppingArea() {
        LoginPage.enterUserName(ConfigReader.getProperty("username"));
        LoginPage.enterPassword(ConfigReader.getProperty("password"));
        LoginPage.clickLoginBtn();
        String actualTitle = HomePage.verifyTitle();
        Assert.assertEquals("Swag Labs",actualTitle);
        Assert.assertTrue(HomePage.isLogoDisplayed());
    }

    @When("user clicks on item with name {string}")
    public void userClicksOnItemWithName(String itemName) {
        HomePage.clickItem(itemName);
    }

    @And("user clicks on the add to cart button")
    public void userClicksOnTheAddToCartButton() {
        ItemPage.clickAddToCart();
    }

    @And("user clicks on the shopping cart button")
    public void userClicksOnTheShoppingCartButton() {
        ItemPage.clickCartButton();
    }

    @And("user clicks on the checkout button")
    public void userClicksOnTheCheckoutButton() {
        CartPage.clickCheckOut();
    }

    @And("user enters the order information as {string},{string},{string}")
    public void userEntersTheOrderInformationAs(String firstName, String lastName, String zipCode) {
        CheckoutStepOne.sendOrderInformation(firstName, lastName, zipCode);
    }

    @And("user clicks on the continue button")
    public void userClicksOnTheContinueButton() {
        CheckoutStepOne.clickContinue();
    }

    @Then("user sees the item name matches that of the {string}")
    public void userSeesTheItemNameMatchesThatOfThe(String itemName) {
        Assert.assertEquals(itemName,CheckoutStepTwo.getItemName());

    }


}
