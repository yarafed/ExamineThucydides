package pages.elements;


import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class Search extends PageObject {

    @FindBy(xpath = "//a[contains(@title,'Account')]")
    WebElementFacade accountLink;

    @FindBy(xpath = "//input[@aria-label='Search']")
    WebElementFacade searchField;

    @FindBy( xpath = "//button[@aria-label='Search Gmail']")
    WebElementFacade searchButton;

    @FindBy( xpath = "//span[text()='Loading...']")
    WebElementFacade loading;

    public Search(WebDriver driver){
        super(driver);
    }

    public void waitForAccountLink() {
        accountLink.waitUntilVisible();
    }

    public void typeTextInSearchField(String text){
      searchField.type(text);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void waitForLoaadingPage() {
        waitForTextToDisappear("Loading...");
    }
}
