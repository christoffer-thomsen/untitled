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
        final var itemName = wrapper.name();
        if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        if (itemName.equals("Aged Brie")) {
            wrapper.increaseQuality();

            wrapper.decreaseSellIn();

            if (wrapper.isExpired()) {
                wrapper.increaseQuality();
            }
        } else if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
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
            wrapper.decreaseQuality();

            wrapper.decreaseSellIn();

            if (wrapper.isExpired()) {
                wrapper.decreaseQuality();
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

        public void decreaseQuality() {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }

        public String name() {
            return item.name;
        }
    }
}