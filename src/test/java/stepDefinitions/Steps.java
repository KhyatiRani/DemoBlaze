package stepDefinitions;

import org.testng.Assert;

import BlazeAction.Blaze;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	Blaze blaze = new Blaze();

	@When("user launches the url")
	public void user_launches_the_url() {
		Blaze.launchTheUrl();
	}

	@Then("^verify if user gets the title of the DemoBlaze Website (.*)$")
	public void verify_if_user__gets_the_title_of_the_DemoBlaze_Website_Title(String Title) {
		Assert.assertTrue(blaze.getTitle().toString().contains(Title));
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		blaze.loginPage();
	}

	@When("^verify if user gets logged in with (.*)$")
	public void verify_is_user_gets_logged_in_with_username(String username) {
		Assert.assertTrue(blaze.getUser().toString().contains(username));

	}

	@When("navigates to the next page")
	public void navigates_to_the_next_page() {
		blaze.callsPostRequestToNavigateToNext();
	}

	@Then("^verify if user gets (.*) from NextPage$")
	public void verify_if_user_gets_MonitorItem_from_NextPage(String MonitorItem) {
		Assert.assertTrue(blaze.nextPageItems().toString().contains(MonitorItem));
	}

	@When("user gets list of phones")
	public void user_gets_list_of_phones() {
		blaze.callsPostRequesttogetphoneItem();

	}

	@Then("^verify if (.*) item is present on that page$")
	public void verify_if_phone_item_is_present_on_that_page(String phone) {
		Assert.assertTrue(blaze.getPhone().toString().contains(phone));
		// Assert.assertEquals(200 ,blaze.getPhone());
	}

	@When("user gets list of laptops")
	public void user_gets_list_of_laptops() {
		blaze.callsPostRequesttogetLaptopItem();
	}

	@Then("^verify if user able to view the (.*) item$")
	public void verify_if_user_able_to_view_the_latop_item(String laptop) {
		Assert.assertTrue(blaze.getLaptops().toString().contains(laptop));
	}

	@When("user gets list of Monitors")
	public void user_gets_list_of_Monitors() {
		blaze.callsPostRequesttogetMonitorItem();
	}

	@Then("^verify if user is able to get the (.*)$")
	public void verify_if_user_is_able_to_get_the_monitor(String monitor) {
		Assert.assertTrue(blaze.getMonitors().toString().contains(monitor));
	}

}
