package com.project.productmove.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class was created at 12/29/2022 23:50:50
 *
 * @author Tuan Vu
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductBatchesAndProduclineDTO {
    ProductBatchesDTO productBatch;
    ProductlineDetailsDTO productlineDetail;

}
