package com.ruanmou.house.houseserver.Controller;


import com.ruanmou.house.housecommon.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {


    @GetMapping("/testApiRequest1")
    public ApiResponse get1(){
        return ApiResponse.ofMessage(10001,"余额不足;");

    }

    @GetMapping("/testex")
    public ApiResponse getex(){
        throw new RuntimeException();

    }

//    @GetMapping("/ex")
//    public ApiResponse ex(){
//
//    }
}
