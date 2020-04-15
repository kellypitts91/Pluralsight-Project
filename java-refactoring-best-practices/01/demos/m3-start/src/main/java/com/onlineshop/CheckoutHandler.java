package com.onlineshop;


import com.onlineshop.entities.Customer;
import com.onlineshop.entities.DeliveryTimeWindow;
import com.onlineshop.entities.Order;
import com.onlineshop.items.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CheckoutHandler {

    public double calculateTotal(Order order){

        double baseTotal = sumItemPrices(order.getItems());
        baseTotal = applyVoucher(order.getVoucher(), baseTotal);
        baseTotal = addDeliveryFee(order.getCustomer(), baseTotal);

        return baseTotal;
    }

    private double sumItemPrices(List<Item> items) {
        double sum = 0;
        for(Item item : items){
            sum += item.price();
        }
        return sum;
    }

    private double applyVoucher(String voucher, double baseTotal) {
        if(isVoucherValid(voucher)){
            baseTotal = BigDecimal.valueOf(baseTotal * 0.95).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        } else {
            System.out.println("Voucher invalid");
        }
        return baseTotal;
    }

    private boolean isVoucherValid(String voucher) {
        return voucher.equals("GIMME_DISCOUNT") || voucher.equals("CHEAPER_PLEASE");
    }

    private double addDeliveryFee(Customer customer, double baseTotal) {
        if(isEligibleForFreeDelivery(customer.getMembership())){
            // do nothing
        } else {
            if(isUSAddress(customer.getAddress())){
                System.out.println("Adding flat delivery fee of 5 USD");
                baseTotal = baseTotal + 5;
            } else {
                System.out.println("Adding flat global delivery fee of 10 USD");
                baseTotal = baseTotal + 10;
            }
        }
        return baseTotal;
    }

    private boolean isEligibleForFreeDelivery(String membership) {
        return membership.equalsIgnoreCase("GOLD");
    }

    private boolean isUSAddress(String address) {
        return address.contains("US");
    }

    public void setDeliveryTimeWindow(DeliveryTimeWindow deliveryTimeWindow){
        System.out.println(String.format("Your Order will delivered some time between %s and %s",
                deliveryTimeWindow.getStart(),
                deliveryTimeWindow.getEnd()));
    }

}
