package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final var item : items) {
            final var applesauce = new ItemWrapper(item);
            doSomething(applesauce);
        }
    }

    private void doSomething(ItemWrapper applesauce) {
        if (applesauce.item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        if (applesauce.item.name.equals("Aged Brie")) {
            increaseQuality(applesauce.item);

            decreaseSellIn(applesauce.item);

            if (isExpired(applesauce.item)) {
                increaseQuality(applesauce.item);
            }
        } else if (applesauce.item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(applesauce.item);

            if (applesauce.item.sellIn < 11) {
                increaseQuality(applesauce.item);
            }

            if (applesauce.item.sellIn < 6) {
                increaseQuality(applesauce.item);
            }

            decreaseSellIn(applesauce.item);

            if (isExpired(applesauce.item)) {
                applesauce.item.quality = 0;
            }
        } else {
            decreaseQuality(applesauce.item);

            decreaseSellIn(applesauce.item);

            if (isExpired(applesauce.item)) {
                decreaseQuality(applesauce.item);
            }
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
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
    }
}