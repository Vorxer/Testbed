package com.dinuras.DTOtestserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarManufacturer {

    String name;
    List<Vehicle> vehicles;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Vehicle{

        String name;
        String bodyType;
        int productionStarted;
        boolean cruiseControl;
        boolean tractionControl;
        Engine engine;
        Gearbox gearbox;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Engine{
            String designation;
            String inductionMethod;
            String fuelDelivery;
            String layout;
            double displacement;
            int capacity;
            int noOfCylinders;
            int peakHP;
            int peakTorque;
            int redLine;

            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Gearbox{
            String type;
            int number;
            List<Double> ratios;

            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }
    }

}








