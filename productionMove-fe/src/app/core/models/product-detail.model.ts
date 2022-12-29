import {ProductLine} from "./product-line.model";
import {ProductBatch} from "./product-batch.model";

export interface ProductDetail {
    id: number;
    status: number;
    place: string;
    warrantyPeriod: number;
    warrantyPeriodFrom?: string;
    warrantyCount?: number;
    productCode: string;
    productLine: ProductLine;
    productBatch: ProductBatch;
    sellBy?: string;
    customerName?: string;
    createdAt: string;
    modifiedAt: string;
    createdBy: string;
    modifiedBy: string;
}
