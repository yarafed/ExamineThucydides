package stories.manageEmails;


import models.User;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.Test;
import requirments.Application;
import steps.GoogleSteps;
import steps.LoginSteps;
import steps.manageEmails.MoveToFolderSteps;
import stories.BaseStoryTest;

@Story(Application.ManageEmails.MoveToFolder.class)
@WithTags({ @WithTag(type = "feature", name = "ManageEmails"),
        @WithTag(type = "story", name = "MoveToFolder") })
public class MoveToFolderStoryTest extends BaseStoryTest {
    @Steps
    GoogleSteps googleSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    MoveToFolderSteps moveToFolderSteps;

    private User user;

    private String folderName;

    private int indexOfSelectMessage;

    @Before
    public void setUp() {
        user = new User("yarynafedoryshyn@gmail.com","yara3579");
        folderName = "Social";
        indexOfSelectMessage = 1;
    }

    @Test
    @Title("Test Case 1: 'Move To' button")
    @WithTag(type = "test", name = "verifyMoveToButton")
    public void verifyMoveToButton() {
        googleSteps.openGooglePage();
        googleSteps.clickGmailLink();
        loginSteps.login(user.getLogin(), user.getPassword());
        moveToFolderSteps.selectCheckbox(indexOfSelectMessage);
        moveToFolderSteps.verifyThatMoveToButtonAppeared();
        moveToFolderSteps.clickMoveToButton();
        moveToFolderSteps.verifyThatPopUpAppeared();
        moveToFolderSteps.selectFolder(folderName);
        moveToFolderSteps.verifyThatMessageIsNotInInboxFolder();
        moveToFolderSteps.moveToFolder("Social");
        moveToFolderSteps.verifyThatMessageIsInFolder("Social");
    }
}