package steps;


import models.Message;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ComposePage;
import pages.ErrorMessage;
import pages.elements.LeftMenu;
import pages.elements.Table;

import static org.fest.assertions.Assertions.assertThat;

public class ComposeSteps extends ScenarioSteps{

    private LeftMenu leftMenu;
    private ComposePage composePage;
    private ErrorMessage errorMessage;
    private Table table;

    public ComposeSteps(Pages pages){
        super(pages);
    }

    @Step
    public void clickComposeButton(){
        leftMenu.clickComposeButton();
    }

    @Step
    public void verifyThatNewWindowMessageAppeared(){
        assertThat(composePage.isNewWindowMessageVisible()).isTrue();
    }

    @Step
    public void clickSendButton(){
        composePage.clickSendButton();
    }

    @Step
    public void verifyThatErrorMessageAppeared(){
        assertThat(errorMessage.isErrorMessageWindowVisible()).isTrue();
    }

    @Step
    public void verifyThatErrorMessageIsDisabled(){
        assertThat(errorMessage.isErrorMessageWindowVisible()).isFalse();
    }

    @Step
    public void clickOkButtonOnErrorMessage(){
        errorMessage.clickOkButton();
    }

    @Step
    public void typeRecipient(String recipient){
        composePage.typeRecipient(recipient);
    }

    @Step
    public void typeSubject(String subject){
        composePage.typeSubject(subject);
    }

    @Step
    public void typeMessage(String message){
        composePage.typeMessage(message);
    }

    @StepGroup
    public void sendEmail(String recipient, String subject, String message){
        typeRecipient(recipient);
        typeSubject(subject);
        typeMessage(message);
        clickSendButton();
    }

    @Step
    public void clickSentMail(){
        leftMenu.clickMenuItem("Sent Mail");
    }

    @Step
    public void verifyThatMessageIsInSentFolder(Message message){
       assertThat(table.isMessageFolder(message,"Sent")).isTrue();
    }
}
