package com.company.carrier;

/**
 * Created by dima on 04.05.17.
 */
public class CarryFactory {
    public PassengerCarrier getPassengerCarrier(int distance, boolean airComunication, boolean railwayCommunication,
                                                boolean carComunication) {
        if (distance <=0) {
            return null;
        }
        if(distance>1000){
            if (airComunication) return new Airplane();
            if(railwayCommunication) return new Train();
            if(carComunication) return new Car();
            return null;
        }
        if(distance<1000&&distance>500){
            if (railwayCommunication) return new Train();
            if(airComunication) return new Airplane();
            if(carComunication) return new Car();
            return null;
        }
        if(distance<500){
            if(carComunication) return new Car();
            if (railwayCommunication) return new Train();
            if(airComunication) return new Airplane();
            return null;
        }
return null;
    }
}
