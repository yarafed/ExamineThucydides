package stories;

import models.Message;
import models.User;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import requirments.Application;
import steps.ComposeSteps;
import steps.GoogleSteps;
import steps.LoginSteps;

@Story(Application.Compose.class)
@WithTag(type = "story", name = "Compose")
public class ComposeStoryTest extends BaseStoryTest {

@Steps
    GoogleSteps googleSteps;
@Steps
    LoginSteps loginSteps;
@Steps
    ComposeSteps composeSteps;

    private User user;

    private Message message;

@Before
    public void setUp() {
        user = new User("yarynafedoryshyn@gmail.com","yara3579");
        message = new Message("yarunaf@gmail.com","subject","message");
    }

    @Test
    @Title("Test Case 2: 'Send' button")
    @WithTag(type = "test", name = "verifySendButton")
    public void verifySendButton(){
        googleSteps.openGooglePage();
        googleSteps.clickGmailLink();
        loginSteps.login(user.getLogin(),user.getPassword());
        composeSteps.clickComposeButton();
        composeSteps.verifyThatNewWindowMessageAppeared();
        composeSteps.clickSendButton();
        composeSteps.verifyThatErrorMessageAppeared();
        composeSteps.clickOkButtonOnErrorMessage();
        composeSteps.verifyThatErrorMessageIsDisabled();
        composeSteps.sendEmail(message.getRecipient(),message.getSubject(),message.getMessage());
        composeSteps.clickSentMail();
        composeSteps.verifyThatMessageIsInSentFolder(message);
    }
}
