package com.onlineshop;


import com.onlineshop.entities.*;
import com.onlineshop.items.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CheckoutHandler {

    private DiscountManager discountManager = new DiscountManager();
    private DeliveryManager deliveryManager = new DeliveryManager();

    public double calculateTotal(Order order){

        double baseTotal = sumItemPrices(order.getItems());
        baseTotal = discountManager.applyVoucher(order.getVoucher(), baseTotal);
        baseTotal = deliveryManager.addDeliveryFee(order.getCustomer(), baseTotal);

        return baseTotal;
    }

    private double sumItemPrices(List<Item> items) {
        double sum = 0;
        for(Item item : items){
            sum += item.price();
        }
        return sum;
    }

    public void setDeliveryTimeWindow(DeliveryTimeWindow deliveryTimeWindow){
        System.out.println(String.format("Your Order will delivered some time between %s and %s",
                deliveryTimeWindow.getStart(),
                deliveryTimeWindow.getEnd()));
    }

}
