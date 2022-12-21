package com.project.productmove.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class created at 12/20/2022 14:52:14
 *
 * @author HoàngKhôngNgủ
 */

@RestController
@RequestMapping("api/v1/")
@Log4j2
public class GeneralController {

    @GetMapping("user/get/-users-by-filter")
    ResponseEntity<Object> responseEntity() {
        return null;
    }
}
