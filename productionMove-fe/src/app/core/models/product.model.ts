import {ProductLine} from "./product-line.model";

export interface Product {
    id: number;
    status: number;
    place: string;
    warrantyPeriod: number;
    warrantyPeriodFrom?: string;
    warrantyCount?: number;
    productCode: string;
    productLine: ProductLine;
    productName: string;
    productBatchId: number;
    createdAt: string;
    modifiedAt: string;
    createdBy: string;
    modifiedBy: string;
}
