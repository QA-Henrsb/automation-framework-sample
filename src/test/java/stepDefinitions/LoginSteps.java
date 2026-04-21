package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.open();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @And("user clicks submit button")
    public void user_clicks_submit_button() {
        // action encapsulated on login()
    }

    @Then("user should see {string}")
    public void user_should_see_result(String result) {

        switch (result) {

            case "success":
                Assert.assertTrue(loginPage.isLoginSuccessful());
                break;

            case "invalid username":
                Assert.assertEquals(
                        loginPage.getErrorMessage(),
                        "Your username is invalid!"
                );
                break;

            case "invalid password":
                Assert.assertEquals(
                        loginPage.getErrorMessage(),
                        "Your password is invalid!"
                );
                break;

            default:
                throw new RuntimeException("Unexpected result: " + result);
        }
    }
}