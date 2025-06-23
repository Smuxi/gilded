package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
        final String AGED_BRIE = "Aged Brie";
        final String SULFURAS = "Sulfuras, Hand of Ragnaros";
        final String CONJURED = "Conjured";

        int qualityChange;

        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals(SULFURAS)) {
                continue;
            }

            if (items[i].name.equals(AGED_BRIE)) {
                if (items[i].sellIn <= 0) {
                    qualityChange = 2;
                }
                else {
                    qualityChange = 1;
                }
            } else if (items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].sellIn <= 0) {
                    qualityChange = items[i].quality * -1;
                }
                else if (items[i].sellIn < 6) {
                    qualityChange = 3;
                } else if (items[i].sellIn < 11) {
                    qualityChange = 2;
                }
                else {
                    qualityChange = 1;
                }
            }
            else {
                if (items[i].sellIn <= 0) {
                    qualityChange = -2;
                }
                else {
                    qualityChange = -1;
                }
            }

            if (items[i].name.equals(CONJURED)) {
                qualityChange *= 2;
            }

            items[i].sellIn--;
            items[i].quality += qualityChange;

            if (items[i].quality < 0) {
                items[i].quality = 0;
            } else if (items[i].quality > 50) {
                items[i].quality = 50;
            }
        }
    }
}
