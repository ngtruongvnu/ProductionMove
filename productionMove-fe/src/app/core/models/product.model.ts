import {ProductLine} from "./product-line.model";

export interface Product {
    product_id: number;
    status: number;
    product_status: number;
    place: string;
    warrantyPeriod: number;
    warrantyFrom?: string;
    warrantyCount?: string;
    so_lan_bao_hanh: number;
    product_code: string;
    productCode: string;
    product_name: string;
    productBatchId: number;
    createdDate: string;
    modifiedDate: string;
    createdBy: string;
    modifiedBy: string;
}
