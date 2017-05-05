package com.company.carrier;

/**
 * Created by dima on 04.05.17.
 */
public class Car extends PassengerCarrier {
    @Override
    public void carry() {
        System.out.println("Автомобиль");
    }
}
