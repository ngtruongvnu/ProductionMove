package com.project.productmove.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * This class created at 12/21/2022 14:49:28
 *
 * @author HoàngKhôngNgủ
 */
@RestController
public class HomeController {

    @GetMapping("/test1")
    public String testRequestHeader (@RequestHeader String authorization) {
        System.out.println("printing the auth "+authorization);
        return "Success";
    }

    @GetMapping("/test2")
    public String handleRequestHeader (@RequestHeader Map<String, String> mapValues) {
        System.out.println("printing the header"+mapValues);
        return "Success";
    }
}
