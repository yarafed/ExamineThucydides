package pages.elements;


import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class TopMenu extends PageObject {

    @FindBy(xpath = "(//div[@class='asa'])[4]")
    WebElementFacade moveToButton;

    @FindBy(xpath = "//div[@role='menuitem' and @title='Social']")
    WebElementFacade socialFolder;

    public TopMenu(WebDriver driver){
        super(driver);
    }

    public void clickMoveToButton(){
        moveToButton.click();
    }

    public void selectFolder(String name) {
        String xPath = "//div[@role='menuitem' and @title='%s']";
        element(By.xpath(String.format(xPath, name))).click();
    }

    public boolean isMoveToButtonVisible(){
        return moveToButton.isVisible();
    }

    public boolean isPopUpVisible(){
        return socialFolder.isVisible();
    }
}
