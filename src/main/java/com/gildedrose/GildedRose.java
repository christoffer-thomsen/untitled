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

            if (wrapper.isExpired()) {
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

            if (wrapper.isExpired()) {
                wrapper.item.quality = 0;
            }
        } else {
            if (wrapper.item.quality > 0) {
                wrapper.item.quality = wrapper.item.quality - 1;
            }

            wrapper.decreaseSellIn();

            if (wrapper.isExpired()) {
                if (wrapper.item.quality > 0) {
                    wrapper.item.quality = wrapper.item.quality - 1;
                }
            }
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

        private boolean isExpired() {
            return item.sellIn < 0;
        }
    }
}