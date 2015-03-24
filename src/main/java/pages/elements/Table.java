package pages.elements;


import models.Message;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;


public class Table extends PageObject{

    @FindBy(xpath = "(//table[@class='F cf zt'])[1]")
    WebElementFacade tableInInboxFolder;

    @FindBy(xpath = "(//table[@class='F cf zt'])[2]")
    WebElementFacade table;

    public Table(WebDriver driver){
        super(driver);
    }

    public void selectCheckbox(int index){
        String xPath = "//tr[%d]//div[@role='checkbox']";
            element(tableInInboxFolder.findElement(By.xpath(String.format(xPath, index)))).click();
    }

    public  List<Message> getContentOfTable(WebElement table) {
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        List<Message> contentOfRows = new ArrayList<Message>();
        WebElement recipient;
        WebElement subject;
        WebElement message = null;
        for (int i = 0; i < rows.size(); i++) {
            recipient = table.findElement(By.xpath(".//tr/td[4]/div[2]/span"));
            subject = rows.get(i).findElement(By.xpath("./td[6]//span[1]"));
            try {
                message = rows.get(i).findElement(By.xpath("./td[6]//span[2]"));
            }catch (NoSuchElementException e){
                contentOfRows.add(new Message(recipient.getText(), subject.getText(),""));
                continue;
            }
            contentOfRows.add(new Message(recipient.getText(), subject.getText(), message.getText()));
        }
        return contentOfRows;
    }

    public boolean isFilteredContentInTable(String text){
        List<Message> contentOfRows = getContentOfTable(table);
        for(Message message:contentOfRows) {
            if(!StringUtils.containsIgnoreCase(message.toString(), text)){
                return false;
            }
        }
        return true;
    }


    public boolean isMessageFolder(Message searchMessage, String folder){
        waitForLoadingTable(folder);
        List<Message> messages = new ArrayList<Message>();
        String textMessage;
        String recipient;
        if(folder.equals("Sent")){
            textMessage = " - "+searchMessage.getMessage();
            recipient = "Ярина Федоришин";
            messages = getContentOfTable(table);
        }else{
            textMessage = searchMessage.getMessage();
            recipient = searchMessage.getRecipient();
                if(folder.equals("Inbox")){
                    messages = getContentOfTable(tableInInboxFolder);
                } else if(folder.equals("Social")){
                    messages = getContentOfTable(table);
            }
        }
        for(Message message:messages) {
            if (message.getMessage().equals(textMessage) && message.getSubject().equals(searchMessage.getSubject()) && message.getRecipient().equals(recipient)) {
                return true;
            }
        }
        return false;
    }

    public void waitForLoadingTable(String url){
        waitFor(titleContains(url));
    }

    public Message getContentOfSelectMessage(int index, String folder){
        Message message = new Message();
        if(folder.equals("Inbox")) {
            message = getContentOfTable(tableInInboxFolder).get(index - 1);
        } else if(folder.equals("Social")){
            message = getContentOfTable(table).get(index - 1);
        }
        return message;
    }


}

