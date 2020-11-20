package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays
            .stream(items)
            .map(ItemWrapper::new)
            .forEach(this::doSomething);
    }

    private void doSomething(ItemWrapper wrapper) {
        if (wrapper.item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        if (wrapper.item.name.equals("Aged Brie")) {
            wrapper.increaseQuality();

            wrapper.decreaseSellIn();

            if (isExpired(wrapper)) {
                wrapper.increaseQuality();
            }
        } else if (wrapper.item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            wrapper.increaseQuality();

            if (wrapper.item.sellIn < 11) {
                wrapper.increaseQuality();
            }

            if (wrapper.item.sellIn < 6) {
                wrapper.increaseQuality();
            }

            wrapper.decreaseSellIn();

            if (isExpired(wrapper)) {
                wrapper.item.quality = 0;
            }
        } else {
            decreaseQuality(wrapper.item);

            wrapper.decreaseSellIn();

            if (isExpired(wrapper)) {
                decreaseQuality(wrapper.item);
            }
        }
    }

    private boolean isExpired(ItemWrapper wrapper) {
        return wrapper.item.sellIn < 0;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static class ItemWrapper {
        final Item item;

        public ItemWrapper(Item item) {
            this.item = item;
        }

        public void increaseQuality() {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        public void decreaseSellIn() {
            item.sellIn = item.sellIn - 1;
        }
    }
}