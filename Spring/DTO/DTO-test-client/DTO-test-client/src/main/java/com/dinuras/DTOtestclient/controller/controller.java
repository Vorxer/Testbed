package com.dinuras.DTOtestclient.controller;

import com.dinuras.DTOtestclient.dto.CarManufacturer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/test/client")
public class controller {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @GetMapping("/runTest")
    public Object runTest() throws CloneNotSupportedException{

        ArrayList<Double> g282Ratios = new ArrayList<>();
        g282Ratios.add(3.50);
        g282Ratios.add(2.05);
        g282Ratios.add(1.38);
        g282Ratios.add(0.94);
        g282Ratios.add(0.72);
        ArrayList<Double> g420gRatios = new ArrayList<>();
        g420gRatios.add(4.227);
        g420gRatios.add(2.528);
        g420gRatios.add(1.669);
        g420gRatios.add(1.226);
        g420gRatios.add(1.000);
        g420gRatios.add(0.828);


        CarManufacturer.Vehicle.Engine m40 = new CarManufacturer.Vehicle.Engine("BMW M40", "NA", "Petrol Injected","inline", 1.8, 1799, 4, 140, 190, 6500);
        CarManufacturer.Vehicle.Engine m50 = new CarManufacturer.Vehicle.Engine("BMW M50", "NA", "Petrol Injected","inline", 2.5, 2499, 6, 200, 240, 6500);
        CarManufacturer.Vehicle.Gearbox g82 = new CarManufacturer.Vehicle.Gearbox("manual",5, g420gRatios);
        CarManufacturer.Vehicle.Gearbox g420g = new CarManufacturer.Vehicle.Gearbox("manual",6, g282Ratios);
        CarManufacturer.Vehicle e30_318i = new CarManufacturer.Vehicle("318i (e30)", "coupe", 1982, false, false, (CarManufacturer.Vehicle.Engine)m40.clone(), (CarManufacturer.Vehicle.Gearbox)g82.clone());
        CarManufacturer.Vehicle e34_518i = new CarManufacturer.Vehicle("518i (e34)", "sedan", 1989, true, false, (CarManufacturer.Vehicle.Engine)m40.clone(), (CarManufacturer.Vehicle.Gearbox)g82.clone());
        CarManufacturer.Vehicle e34_525i = new CarManufacturer.Vehicle("525i (e34)", "coupe", 1989, true, true, (CarManufacturer.Vehicle.Engine)m50.clone(), (CarManufacturer.Vehicle.Gearbox)g420g.clone());
        ArrayList<CarManufacturer.Vehicle> cars = new ArrayList<>();
        cars.add(e30_318i);
        cars.add(e34_518i);
        cars.add(e34_525i);
        CarManufacturer bmw = new CarManufacturer("Bayerische Motoren Werke AG", cars);

        String url = "http://localhost:9101/test/server/runTest";

        HttpEntity<CarManufacturer> httpEntity = new HttpEntity<>(bmw, new HttpHeaders());

        return restTemplate().exchange(url, HttpMethod.POST, httpEntity, CarManufacturer.class);

    }


    @GetMapping("/runTest2")
    public Object runTest2() throws CloneNotSupportedException{

        ArrayList<Double> g282Ratios = new ArrayList<>();
        g282Ratios.add(3.50);
        g282Ratios.add(2.05);
        g282Ratios.add(1.38);
        g282Ratios.add(0.94);
        g282Ratios.add(0.72);
        ArrayList<Double> g420gRatios = new ArrayList<>();
        g420gRatios.add(4.227);
        g420gRatios.add(2.528);
        g420gRatios.add(1.669);
        g420gRatios.add(1.226);
        g420gRatios.add(1.000);
        g420gRatios.add(0.828);


        CarManufacturer.Vehicle.Engine m40 = new CarManufacturer.Vehicle.Engine("BMW M40", "NA", "Petrol Injected","inline", 1.8, 1799, 4, 140, 190, 6500);
        CarManufacturer.Vehicle.Engine m50 = new CarManufacturer.Vehicle.Engine("BMW M50", "NA", "Petrol Injected","inline", 2.5, 2499, 6, 200, 240, 6500);
        CarManufacturer.Vehicle.Gearbox g82 = new CarManufacturer.Vehicle.Gearbox("manual",5, g420gRatios);
        CarManufacturer.Vehicle.Gearbox g420g = new CarManufacturer.Vehicle.Gearbox("manual",6, g282Ratios);
        CarManufacturer.Vehicle e30_318i = new CarManufacturer.Vehicle("318i (e30)", "coupe", 1982, false, false, m40, g82);
        CarManufacturer.Vehicle e34_518i = new CarManufacturer.Vehicle("518i (e34)", "sedan", 1989, true, false, m40, g82);
        CarManufacturer.Vehicle e34_525i = new CarManufacturer.Vehicle("525i (e34)", "coupe", 1989, true, true, m50, g420g);
        ArrayList<CarManufacturer.Vehicle> cars = new ArrayList<>();
        cars.add(e30_318i);
        cars.add(e34_518i);
        cars.add(e34_525i);
        CarManufacturer bmw = new CarManufacturer("Bayerische Motoren Werke AG", cars);

        String url = "http://localhost:9101/test/server/runTest2";

        HttpEntity<CarManufacturer> httpEntity = new HttpEntity<>(bmw, new HttpHeaders());

        return restTemplate().exchange(url, HttpMethod.POST, httpEntity, CarManufacturer.class);

    }

}
