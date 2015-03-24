package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import pages.elements.Header;
import pages.elements.Table;

import static org.fest.assertions.Assertions.assertThat;

public class SearchSteps extends ScenarioSteps{
    private Header header;
    private Table table;

    public SearchSteps(Pages pages){
        super(pages);
    }

    @Step
    public void typeTextInSearchField(String text){
       header.typeTextInSearchField(text);
    }

    @Step
    public void clickSearchButton(){
        header.clickSearchButton();
    }

    @StepGroup
    public void searchText(String text){
        typeTextInSearchField(text);
        clickSearchButton();
    }

    @Step
    public void verifyThatInboxIsFiltered(String searchCriteria){
        assertThat(table.isFilteredContentInTable(searchCriteria)).isTrue();
    }

}
