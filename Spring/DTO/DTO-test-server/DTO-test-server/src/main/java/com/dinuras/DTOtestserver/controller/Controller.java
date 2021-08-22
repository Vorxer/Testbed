package com.dinuras.DTOtestserver.controller;

import com.dinuras.DTOtestserver.dto.CarManufacturer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test/server")
public class Controller {

    @PostMapping("/runTest")
    public Object runTest(@RequestBody Object object) throws CloneNotSupportedException {

        System.out.println(object.toString());
        return object;

    }

    @PostMapping("/runTest2")
    public CarManufacturer runTest2(@RequestBody CarManufacturer carManufacturer) throws CloneNotSupportedException {

        System.out.println(carManufacturer.toString());
        return carManufacturer;

    }
}