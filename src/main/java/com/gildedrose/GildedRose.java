package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }

                decreaseSellIn(item);

                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality < 50) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }

                decreaseSellIn(item);

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
            } else {
                decreaseQuality(item);

                decreaseSellIn(item);

                if (item.sellIn < 0) {
                    decreaseQuality(item);
                }
            }
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

}