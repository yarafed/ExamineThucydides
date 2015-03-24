package pages;


import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class ErrorMessage extends PageObject{

    @FindBy(xpath = "//div[@class='Kj-JD' and @role='alertdialog']")
    WebElementFacade errorMessageWindow;

    @FindBy(xpath = "//button[@name='ok']")
    WebElementFacade okButton;

    public ErrorMessage(WebDriver driver){
        super(driver);
    }

    public boolean isErrorMessageWindowVisible(){
        return errorMessageWindow.isVisible();
    }

    public void clickOkButton(){
        okButton.click();
    }
}
