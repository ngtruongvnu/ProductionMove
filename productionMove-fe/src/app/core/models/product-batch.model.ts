import {ProductLine} from "./product-line.model";

export interface ProductBatch {
    id: number,
    producedAt: number,
    quantity: number,
    createdBy?: string,
    createdAt?: string,
    modifiedBy?: string,
    modifiedAt?: string,
}
export interface ProductBatchFactory {
    productBatch: ProductBatch,
    productlineDetail: ProductLine
}
