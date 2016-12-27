package steps;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class UiSteps extends Steps{
	private static WebDriver driver = null;
	public static String currentUrl;
	
	@BeforeStories
	public static void initialize() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}
		driver.manage().deleteAllCookies();
	}
	
	@Given("I open the url $url")
	public void openUrl(String url) {
		driver.get("http://" + url +"/computers");
	}
	@When("I click on the 'Add new computer' button")
	public void addNewComputer() {
		driver.findElement(By.id("add")).click();
	}

	@When("I enter '$name' as computer name")
	public void inputComputerName(String name) {
		WebElement compName = driver.findElement(By.id("name"));
		compName.clear();
		compName.sendKeys(name);
	}

	@When("I enter the date $date in the Introduced Date field")
	public void introducedDate(String date) {
		WebElement intrDate = driver.findElement(By.id("introduced"));
		intrDate.clear();
		intrDate.sendKeys(date);
	}

	@When("I enter the date $date in the Discontinued Date field")
	public void discontinuedDate(String date) {
		WebElement discDate = driver.findElement(By.id("discontinued"));
		discDate.clear();
		discDate.sendKeys(date);
	}
	
	@Then("I click on the 'next page' button")
	@When("I click on the 'next page' button")
	public void clickOnNextPage(){
		WebElement buttonNext = driver.findElement(By.xpath("//a[contains(., 'Next →')]"));
		buttonNext.click();
	}
	
	@Then("I click on the 'previous page' button")
	public void clickOnPreviousPage(){
		WebElement buttonNext = driver.findElement(By.xpath("//a[contains(., '← Previous')]"));
		buttonNext.click();
	}
	
	@When("I choose $company from the Company dropdown")
	@Then("I choose $company from the Company dropdown")
	public void selectingCompany(String company) {
		WebElement dropdown = driver.findElement(By.id("company"));
		dropdown.click();
		Select item = new Select(dropdown);
		item.selectByVisibleText(company);
	}

	@Then("I click on the 'Create this computer' button")
	public void createComputer(){
		driver.findElement(By.cssSelector(".btn.primary")).click();
	}
	
	@Then("I search for the computer with the name of $pcname")
	public void searchingForAComputer(String pcname){
		WebElement searchField = driver.findElement(By.cssSelector("#searchbox"));
		searchField.click();
		searchField.sendKeys(pcname);
		searchField.sendKeys(Keys.ENTER);
	}
	
	@Then("I open the previously created computer whose name is $name")
	public void openingAComputer(String name){
		WebElement computer = driver.findElement(By.partialLinkText(name));
		computer.click();
		currentUrl = driver.getCurrentUrl();
		
	}
	
	@Then("I update the name of the computer with $name")
	public void updateComputerName(String name){
		inputComputerName(name);
	}
	
	@Then("I update the Introduced and Discontinued dates with $intDate and $discDate respectively")
	public void updatingDates(String intDate, String discDate){
		discontinuedDate(discDate);
		introducedDate(intDate);
	}
	
	@Then("I save the updated computer")
	public void savingTheUpdatedPC(){
		createComputer();
	}
	
	@Then("I click on the 'Delete this computer' button")
	public void deleteComputer(){
		driver.findElement(By.cssSelector(".btn.danger")).click();
	}
	
	@Then("I click on the 'Cancel' button")
	public void cancelComputer(){
		driver.findElement(By.xpath("//a[contains(., 'Cancel')]")).click();
	}
	
	@Then("I verify that the message '$message' is displayed on screen")
	public void verifyText(String message){
		assertText(message);
	}
	
	@Then("I verify that the format of the date isn't correct")
	public void errorOnDateFormat(){
		driver.findElement(By.cssSelector(".clearfix.error"));
	}
	
	@Then("I verify that no new computer can be created with an empty name")
	public void emptyComputerName(){
		errorOnDateFormat();
	}
	
	@Then("I verify that I'm on page number $pageNumber")
	public void pageNumber(String pageNumber){
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.endsWith(pageNumber));
	}
	
	@Then("I verify that I'm on the main page")
	public void mainPage(){
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(!currentUrl.contains("?p="));
	}
	
	private void assertText(String message){
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue("Text not found!", bodyText.contains(message));
	}
	
	
}
