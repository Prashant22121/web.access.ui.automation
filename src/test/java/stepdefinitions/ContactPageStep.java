package stepdefinitions;

import commonfunctions.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ContactPage;
import pageobjects.HomePage;


public class ContactPageStep {

    public ContactPage contactPageObject;
    public HomePage homePageObject;
    @Given("^I launch the url$")
    public void iLaunchTheUrl() throws Exception {

        Base.initialize();
        Base.launchUrl();
    }

    @When("^I navigate to contact page$")
    public void iNavigateToContactPage() {

        homePageObject=new HomePage();
        contactPageObject=homePageObject.clickOnContactLink();
    }

    @And("^I click on submit button$")
    public void iClickOnSubmitButton() {

        contactPageObject.clickOnSubmit();
        contactPageObject.verifyContactPageError();
        contactPageObject.enterDetailsAndVerifyError();
    }

    @Then("^I verify the error message$")
    public void iVerifyTheErrorMessage() {

        contactPageObject.verifyContactPageError();
    }

    @And("I enter the details")
    public void iEnterTheDetails() {

        contactPageObject.enterDetailsAndVerifyError();
    }
}
