import {ProductLine} from "./product-line.model";

export interface Product {
    product_id: number;
    status: number;
    place: string;
    warrantyPeriod: number;
    warrantyPeriodFrom?: string;
    so_lan_bao_hanh: number;
    product_code: string;
    product_name: string;
    productBatchId: number;
    createdAt: string;
    modifiedAt: string;
    createdBy: string;
    modifiedBy: string;
}
