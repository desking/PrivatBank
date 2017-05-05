package com.company;

import com.company.carrier.CarryFactory;
import com.company.carrier.PassengerCarrier;

public class Main {

    public static void main(String[] args) {

        CarryFactory carryFactory = new CarryFactory();
        PassengerCarrier passengerCarrier1 = carryFactory.getPassengerCarrier(1250, true, true, true);
        passengerCarrier1.carry();
        PassengerCarrier passengerCarrier2 = carryFactory.getPassengerCarrier(700, true, true, true);
        passengerCarrier2.carry();
        PassengerCarrier passengerCarrier3 = carryFactory.getPassengerCarrier(300, true, true, true);
        passengerCarrier3.carry();

        PassengerCarrier passengerCarrier4 = carryFactory.getPassengerCarrier(1250, false, true, true);
        passengerCarrier4.carry();
        PassengerCarrier passengerCarrier5 = carryFactory.getPassengerCarrier(700, true, false, true);
        passengerCarrier5.carry();
        PassengerCarrier passengerCarrier6 = carryFactory.getPassengerCarrier(300, false, true, false);
        passengerCarrier6.carry();
    }
}
