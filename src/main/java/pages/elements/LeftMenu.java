package pages.elements;


import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftMenu extends PageObject {

    @FindBy(xpath = "//div[@class='nM']//span[text()='More']")
    WebElementFacade moreButton;

    @FindBy(xpath = "//div[text()='COMPOSE']")
    WebElementFacade composeButton;

   public LeftMenu(WebDriver driver){
        super(driver);
    }

   public void clickComposeButton(){
       composeButton.click();
   }

   public void clickMenuItem(String name){
       String xPath = "//a[text()='%s']";
       element(By.xpath(String.format(xPath, name))).click();
   }

   public void clickMoreButton(){
       moreButton.click();
   }

}
