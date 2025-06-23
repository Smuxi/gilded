package com.gildedrose;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    private Item[] items = new Item[1];
    private GildedRose app;

    @When("I update the quality")
    public void i_update_the_quality() {

        app.updateQuality();
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

