package pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageObject{

    @FindBy(id = "Email")
    private WebElementFacade email;

    @FindBy(id = "Passwd")
    private WebElementFacade passwd;

    @FindBy(id = "signIn")
    private WebElementFacade signIn;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void typeEmail(String mail){
        email.type(mail);
    }

    public void typePassword(String password){
        passwd.type(password);
    }

    public void clickSignIn(){
        signIn.click();
    }
}
