package com.thoughtworks.course.pos.model;

import java.util.List;

public class Promotion {
    private final PromotionType type;
    private final List<String> barcodes;

    public Promotion(PromotionType type, List<String> barcodes) {
        this.type = type;
        this.barcodes = barcodes;
    }

    public PromotionType getType() {
        return type;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }
}
