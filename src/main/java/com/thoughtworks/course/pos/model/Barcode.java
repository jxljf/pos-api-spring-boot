package com.thoughtworks.course.pos.model;

/**
 * 条码
 */
public class Barcode extends ToString {
    public String code;
    public int count;

    public Barcode(String code, int count) {
        this.code = code;
        this.count = count;
    }
}
