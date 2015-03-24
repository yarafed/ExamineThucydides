package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pages.GooglePage;
import pages.LoginPage;

import static org.fest.assertions.Assertions.assertThat;

public class GoogleSteps extends ScenarioSteps{

    private GooglePage googlePage;
    private LoginPage loginPage;

    public GoogleSteps(Pages pages){
        super(pages);
    }

    @Step
    public void openGooglePage(){
        googlePage.open();
        assertThat(googlePage.getTitle().trim()).isEqualTo("Google");
    }

    @Step
    public void clickGmailLink(){
        googlePage.clickGmailLink();
        assertThat(loginPage.getTitle().trim()).isEqualTo("Gmail");
    }
}
