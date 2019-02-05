package com.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

    public MyStepdefs(){

    }

    private SearchFields _searchFields;
    public MyStepdefs(SearchFields searchFields) {
        _searchFields = searchFields;
    }

    @Given("I have opened google home page")
    public void iOpen() {
    }

    @When("I search a {string} text")
    public void iSearchAText(String searchtext) {
        System.out.println(searchtext);
        System.out.println(_searchFields.text);
    }

    @Then("I validate the outcomes")
    public void iValidate() {
    }

}
