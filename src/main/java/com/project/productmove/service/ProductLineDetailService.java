package com.project.productmove.service;


import org.springframework.stereotype.Component;

@Component
public interface ProductLineDetailService {

    String checkProductWarranty(long productLine);
}
