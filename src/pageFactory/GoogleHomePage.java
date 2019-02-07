package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.Selenium;

public class GoogleHomePage {

	@FindBy(how = How.NAME, using = "btnK")
	private WebElement btnSearch;

	@FindBy(how = How.NAME, using = "q")
	private WebElement tbSearchField;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'More for Pune')]")
	private WebElement lblSearchText;

	public GoogleHomePage() {
		// TODO Auto-generated constructor stub
		Selenium.driver.get("https://www.google.com/");
		PageFactory.initElements(Selenium.driver, GoogleHomePage.class);
	}

	public void search(String text) {

		btnSearch.sendKeys(text);

		tbSearchField.click();

		System.out.println(lblSearchText.getText());
	}
}
