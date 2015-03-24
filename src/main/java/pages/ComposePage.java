package pages;


import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposePage extends PageObject {

    @FindBy(xpath = "//textarea[@aria-label='To']")
    WebElementFacade recipient;

    @FindBy(xpath  = "//input[@name='subjectbox']")
    WebElementFacade subject;

    @FindBy(css = "div.Am.Al.editable.LW-avf")
    WebElementFacade message;

    @FindBy(xpath = "//div[text()='Send']")
    WebElementFacade sendButton;

    @FindBy(xpath ="//div[@class='nH Hd']")
    WebElementFacade newMessageWindow;

    public ComposePage(WebDriver driver){
        super(driver);
    }

    public void typeRecipient(String text){
        recipient.type(text);
    }

    public void typeSubject(String text){
        subject.type(text);
    }

    public void typeMessage(String text){
        message.type(text);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public boolean isNewWindowMessageVisible(){
        return newMessageWindow.isVisible();
    }
}
