package com.gildedrose;

class ItemWrapper {
    private final Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        if (item.name.equals("Aged Brie")) {
            increaseQuality();

            decreaseSellIn();

            if (isExpired()) {
                increaseQuality();
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality();

            if (item.sellIn < 11) {
                increaseQuality();
            }

            if (item.sellIn < 6) {
                increaseQuality();
            }

            decreaseSellIn();

            if (isExpired()) {
                item.quality = 0;
            }
        } else {
            decreaseQuality();

            decreaseSellIn();

            if (isExpired()) {
                decreaseQuality();
            }
        }
    }

    private void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isExpired() {
        return item.sellIn < 0;
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}