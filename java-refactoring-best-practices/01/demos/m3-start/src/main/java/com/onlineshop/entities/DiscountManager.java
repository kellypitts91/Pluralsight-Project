package com.onlineshop.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountManager {
    public double applyVoucher(String voucher, double baseTotal) {
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
}
