package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                agedBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                backstagePasses(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

            } else if (item.name.equals("Conjured")) {
                conjured(item);
            } else {
                regularItem(item);
            }
        }
    }

    private void conjured(Item item) {
        DecreaseQuality(item);
        DecreaseQuality(item);
        DecreaseSellIn(item);
        if (item.sellIn < 0) {
            DecreaseQuality(item);
            DecreaseQuality(item);
        }
    }

    private void regularItem(Item item) {
        DecreaseQuality(item);

        DecreaseSellIn(item);

        if (item.sellIn < 0) {
            DecreaseQuality(item);
        }
    }

    private void DecreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void backstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                IncreaseQuality(item);
            }

            if (item.sellIn < 6) {
                IncreaseQuality(item);
            }
        }

        DecreaseSellIn(item);

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void agedBrie(Item item) {
        IncreaseQuality(item);

        DecreaseSellIn(item);

        if (item.sellIn < 0) {
            IncreaseQuality(item);
        }
    }

    private void IncreaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void DecreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}