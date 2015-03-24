package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;



@DefaultUrl("https://www.google.com.ua")
public class GooglePage extends PageObject{

   @FindBy(xpath = "//a[text()='Gmail']")
    private WebElementFacade gmailLink;

    @WhenPageOpens
    public void whenPageOpens() {
        gmailLink.waitUntilVisible();
    }

    public void clickGmailLink(){
        gmailLink.click();
    }
}
