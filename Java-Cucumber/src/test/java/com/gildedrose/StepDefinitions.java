package com.gildedrose;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    private Item[] items = new Item[1];
    private GildedRose app;

    @Given("The item as {string}")
    public void initial_sellin_is_and_quality_is(String name) {
        items[0] = new Item(name, 0, 0);
        app = new GildedRose(items);
    }

    @When("I update the quality")
    public void i_update_the_quality() {

        app.updateQuality();
    }

    @Then("I should get item as {string}")
    public void i_should_get_sellin_as_and_quality_as(String expected) {
        assertEquals(expected, app.items[0].name);
    }

    @Given("An item named {string} with sellIn {int} and quality {int}")
    public void anItemNamedWithSellInAndQuality(String name, int sellIn, int quality) {
        items[0] = new Item(name, sellIn, quality);
        app = new GildedRose(items);
    }

    @Then("The item should have sellIn {int} and quality {int}")
    public void theItemShouldHaveSellInAndQuality(int sellIn, int quality) {
        assertEquals(sellIn, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);
    }
}

