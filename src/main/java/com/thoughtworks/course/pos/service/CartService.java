package com.thoughtworks.course.pos.service;

import com.thoughtworks.course.pos.model.Barcode;
import com.thoughtworks.course.pos.model.CartItem;
import com.thoughtworks.course.pos.model.Item;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class CartService {
    private final List<Item> items;

    public CartService() {
        this.items = Arrays.asList(
                new Item("方便面", "袋", 4.50f, "ITEM000000", "./imgs/instant-noodles.jpeg"),
                new Item("羽毛球", "个", 1.00f, "ITEM000001", "./imgs/badminton.png"),
                new Item("荔枝", "斤", 15.00f, "ITEM000002", "./imgs/litchi.jpg"),
                new Item("苹果", "斤", 5.50f, "ITEM000003", "./imgs/apple.jpeg"),
                new Item("电池", "个", 2.00f, "ITEM000004", "./imgs/battery.jpeg"),
                new Item("可口可乐", "瓶", 3.00f, "ITEM000005", "./imgs/coco-cola.jpg")
        );
    }

    public List<CartItem> scan(List<String> rawBarcodes) {
        /*
         * 在此实现对 rawBarcodes 的扫描，返回 CartItem 的 List
         * 步骤:
         * 1. 将 List<String> 转换为 List<Barcode>
         * 2. 合并 List<Barcode> 中 code 相同的项目
         * 3. 查找 items，将 List<Barcode> 转换为 List<CartItem>
         */
        List<Barcode> barcodes = parseBarcodes(rawBarcodes);
        List<Barcode> mergedBarcodes = mergeBarcodes(barcodes);
        return createCartItems(mergedBarcodes);
    }

    /**
     * 将输入的 条码字符串 转换为 条码类型
     *
     * @param rawBarcodes String 的 List
     * @return Barcode 的 List
     */
    private List<Barcode> parseBarcodes(List<String> rawBarcodes) {
        List<Barcode> barcodes = new LinkedList<>();
        for (String rawBarcode : rawBarcodes) {
            String[] split = rawBarcode.split("-");
            String barcode = split[0];
            int count = 1;
            if (split.length > 1) {
                count = Integer.parseInt(split[1]);
            }
            barcodes.add(new Barcode(barcode, count));
        }
        return barcodes;
    }

    /**
     * 将输入的 条码字符串 转换为 条码
     *
     * @param barcodes Barcode 的 List
     * @return 合并后的 Barcode 的 List
     */
    private List<Barcode> mergeBarcodes(List<Barcode> barcodes) {
        List<Barcode> mergedBarcodes = new LinkedList<>();
        for (Barcode barcode : barcodes) {
            boolean existed = false;
            for (Barcode mergedBarcode : mergedBarcodes) {
                if (barcode.code.equals(mergedBarcode.code)) {
                    mergedBarcode.count += barcode.count;
                    existed = true;
                }
            }
            if (!existed) {
                mergedBarcodes.add(barcode);
            }
        }
        return mergedBarcodes;
    }

    /**
     * 按照 条码 创建对应的 购物车项目
     *
     * @param barcodes Barcode 的 List
     * @return 与输入条码对应的 CartItem 的 List
     */
    private List<CartItem> createCartItems(List<Barcode> barcodes) {
        List<CartItem> cartItems = new LinkedList<>();
        for (Item item : items) {
            for (Barcode barcode : barcodes) {
                if (barcode.code.equals(item.barcode)) {
                    cartItems.add(
                            new CartItem(
                                    item.name, item.unit, item.price, item.barcode, item.img,
                                    barcode.count, item.price * barcode.count
                            )
                    );
                }
            }
        }
        return cartItems;
    }
}
