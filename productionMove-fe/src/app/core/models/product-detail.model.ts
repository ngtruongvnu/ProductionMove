import {Product} from "./product.model";
import {ProductLine} from "./product-line.model";
import {ProductBatch} from "./product-batch.model";

export interface ProductDetail {
    product: Product,
    product_line: ProductLine,
    product_batch: ProductBatch,
    sellBy?: string,
    customer?: string,
}
