package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final var item : items) {
            final var applesauce = new Applesauce(item);
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            if (item.name.equals("Aged Brie")) {
                increaseQuality(item);

                decreaseSellIn(item);

                if (isExpired(item)) {
                    increaseQuality(item);
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(item);

                if (item.sellIn < 11) {
                    increaseQuality(item);
                }

                if (item.sellIn < 6) {
                    increaseQuality(item);
                }

                decreaseSellIn(item);

                if (isExpired(item)) {
                    item.quality = 0;
                }
            } else {
                decreaseQuality(item);

                decreaseSellIn(item);

                if (isExpired(item)) {
                    decreaseQuality(item);
                }
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

    private static class Applesauce {
        final Item item;

        public Applesauce(Item item) {
            this.item = item;
        }
    }
}