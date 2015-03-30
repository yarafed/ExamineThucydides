package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LoginPage;
import pages.elements.Search;

import static org.fest.assertions.Assertions.assertThat;

public class LoginSteps extends ScenarioSteps{

    private LoginPage loginPage;
    private Search search;

    public LoginSteps(Pages pages){
        super(pages);
    }

    @StepGroup
    public void login(String email,String password){
        typeEmail(email);
        typePassword(password);
        clickSignIn();
        verifyAuthorization();
    }

    @Step
    public void typeEmail(String email){
        loginPage.typeEmail(email);
    }

    @Step
    public void typePassword(String password){
        loginPage.typePassword(password);
    }

    @Step
    public void clickSignIn(){
        loginPage.clickSignIn();
    }

    @Step
    public void verifyAuthorization(){
        search.waitForAccountLink();
        assertThat(getDriver().getCurrentUrl().contains("inbox")).isTrue();
    }

}
