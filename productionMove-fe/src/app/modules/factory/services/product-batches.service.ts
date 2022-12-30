import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductBatch, ProductBatchFactory} from "../../../core/models/product-batch.model";

@Injectable({
    providedIn: 'root'
})
export class ProductBatchesService {

    private API_URL = 'http://localhost:8087/api/v1/factory';
    constructor(private http: HttpClient) {
    }

    getAllProductBatches(userId: number) : Observable<ProductBatchFactory[]> {
        return this.http.get<ProductBatchFactory[]>(`${this.API_URL}/get-product-batch`, {
            params: {
                user_id: userId.toString()
            }
        });
    }

    insertProductBatch(productBatch : any) {
        return this.http.post(`${this.API_URL}/insert-products`, {}, {
            responseType: 'text',
            params: {
                productline_id: productBatch.productline_id.toString(),
                place_at: productBatch.place_at.toString(),
                quantity: productBatch.quantity.toString(),
                user_id: productBatch.user_id.toString()
            }
        });
    }
}
