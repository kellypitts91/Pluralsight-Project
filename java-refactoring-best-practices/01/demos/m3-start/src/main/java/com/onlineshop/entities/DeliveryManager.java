package com.onlineshop.entities;

public class DeliveryManager {

    public double addDeliveryFee(Customer customer, double baseTotal) {
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
}
