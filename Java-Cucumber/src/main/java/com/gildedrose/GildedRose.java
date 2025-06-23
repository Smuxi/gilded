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

        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES)) {
                if (items[i].quality > 0 && !items[i].name.equals(SULFURAS)) {
                        items[i].quality--;
                }
            } else if (items[i].quality < 50) {
                    items[i].quality++;

                    if (items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality++;
                        }

                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality++;
                        }
                    }
            }

            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals(AGED_BRIE)) {
                    if (items[i].quality < 50) {
                        items[i].quality++;
                    }
                } else if (items[i].name.equals(BACKSTAGE_PASSES)) {
                    items[i].quality = 0;
                } else if (items[i].quality > 0 && !items[i].name.equals(SULFURAS)) {
                    items[i].quality--;
                }
            }
        }
    }
}
