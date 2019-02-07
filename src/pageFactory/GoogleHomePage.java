package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.Selenium;

public class GoogleHomePage {

	@FindBy(name = "btnK")
	private WebElement btnSearch;

	@FindBy(how = How.NAME, using = "q")
	private WebElement tbSearchField;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'More for Pune')]")
	private WebElement lblSearchText;

	@FindBys({ @FindBy(xpath = "//span[contains(text(), 'More for Pune')]") })
	private WebElement lblSearchText1;

	@FindAll({ @FindBy(xpath = "//span[contains(text(), 'More for Pune')]") })
	private WebElement ListlblSearchText;

	public GoogleHomePage() {
		// TODO Auto-generated constructor stub
		Selenium.driver.get("https://www.google.com/");
		PageFactory.initElements(Selenium.driver, this);
	}

	public void search(String text) {

		tbSearchField.sendKeys(text);

		btnSearch.click();

		System.out.println(lblSearchText.getText());
	}
}
