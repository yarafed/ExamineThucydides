package stories;

import models.User;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Before;
import org.junit.Test;
import requirments.Application;
import steps.GoogleSteps;
import steps.LoginSteps;
import steps.SearchSteps;

@Story(Application.Search.class)
@WithTag(type = "story", name = "Search")
public class SearchStoryTest extends BaseStoryTest {
    @Steps
    GoogleSteps googleSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    SearchSteps searchSteps;

    private User user;
    private String searchCriteria;
    @Before
    public void setUp() {
        user = new User("yarynafedoryshyn@gmail.com","yara3579");
        searchCriteria = "hi";
    }

    @Test
    @Title("Test Case 3: Search field")
    @WithTag(type = "test", name = "verifySearchField")
    public void verifySearchField(){
        googleSteps.openGooglePage();
        googleSteps.clickGmailLink();
        loginSteps.login(user.getLogin(),user.getPassword());
        searchSteps.searchText(searchCriteria);
        searchSteps.verifyThatInboxIsFiltered(searchCriteria);
    }
}
