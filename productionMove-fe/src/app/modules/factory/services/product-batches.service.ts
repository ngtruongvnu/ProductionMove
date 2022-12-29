import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductBatch} from "../../../core/models/product-batch.model";

@Injectable({
    providedIn: 'root'
})
export class ProductBatchesService {

    constructor(private http: HttpClient) {
    }

    getAllProductBatches() : Observable<ProductBatch[]> {
        return this.http.get<ProductBatch[]>('http://localhost:8080/api/product-batches');
    }
    insertProductBatch(productBatch: ProductBatch) : Observable<string> {
        return this.http.post<string>('http://localhost:8080/api/product-batches', productBatch);
    }
}
