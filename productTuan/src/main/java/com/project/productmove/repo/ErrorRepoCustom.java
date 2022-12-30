package com.project.productmove.repo;

import java.util.List;

public interface ErrorRepoCustom {

 List<Object[]> getErrorProductToFilter();
 List<Object[]> listProductLineError();

 List<Object[]> getErrorProductByWarehouse(long WarehouseId);
}
