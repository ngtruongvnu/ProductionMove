package com.project.productmove.repo;

import java.util.List;

public interface ProductRepoCustom {

    List<Object[]> listProductLineCount();

    List<Object[]> listProductWantWarranty(long userId);

}
