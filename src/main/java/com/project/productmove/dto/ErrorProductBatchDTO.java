package com.project.productmove.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * This class was created at 12/29/2022 15:58:58
 *
 * @author Minh.LN
 */
@Data
@ToString
@AllArgsConstructor
public class ErrorProductBatchDTO {
    Long idProductBatch;
    Float error;

}
