import {ProductLine} from "./product-line.model";

export interface ProductBatch {
    id: number,
    productLine?: ProductLine,
    productName: string,
    quantity: number,
    createdBy?: string,
    createdAt?: string,
    modifiedBy?: string,
    modifiedAt?: string,
}
