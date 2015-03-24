package steps.manageEmails;


import models.Message;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pages.elements.LeftMenu;
import pages.elements.Table;
import pages.elements.TopMenu;

import static org.fest.assertions.Assertions.assertThat;

public class MoveToFolderSteps extends ScenarioSteps{

    private Table table;

    private TopMenu topMenu;

    private Message message;

    private LeftMenu leftMenu;

    public MoveToFolderSteps(Pages pages){
        super(pages);
    }

    @StepGroup
    public void selectCheckbox(int index){
        table.selectCheckbox(index);
        message = table.getContentOfSelectMessage(index, "Inbox");
    }

    @Step
    public void verifyThatMoveToButtonAppeared(){
        topMenu.isMoveToButtonVisible();
    }

    @Step
    public void clickMoveToButton(){
        topMenu.clickMoveToButton();
    }

    @Step
    public void verifyThatPopUpAppeared(){
        topMenu.isPopUpVisible();
    }

    @Step
    public void selectFolder(String name){
        topMenu.selectFolder(name);
    }

    @Step
    public void verifyThatMessageIsNotInInboxFolder(){
        assertThat(table.isMessageFolder(message,"Inbox")).isFalse();
    }

    @Step
    public void moveToFolder(String menuItem){
        leftMenu.clickMoreButton();
        leftMenu.clickMenuItem(menuItem);
    }

    @Step
    public void verifyThatMessageIsInFolder(String folder){
        assertThat(table.isMessageFolder(message,folder)).isTrue();
    }
}
