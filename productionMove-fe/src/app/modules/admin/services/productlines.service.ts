import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProductLine} from "../../../core/models/product-line.model";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ProductlinesService {
    private readonly API_URL = 'http://localhost:8087/api/v1/productline';

    constructor(private http: HttpClient) {
    }

    getProductLines(): Observable<ProductLine[]> {
        return this.http.get<ProductLine[]>(`${this.API_URL}/get-all`);
    }

    getProductLineDetail(id: number): Observable<ProductLine> {
        return this.http.get<ProductLine>(`${this.API_URL}/${id}`);
    }

    insertProductLine(productLine: ProductLine) {
        return this.http.post(`${this.API_URL}/insert-productline`, productLine, {
            responseType: 'text'
        });
    }

    deleteProductLine(id: number) {
        return this.http.delete(`${this.API_URL}/${id}`, {
            responseType: 'text'
        });
    }

    updateProductLine(productLine: ProductLine) {
        return this.http.put(`${this.API_URL}/${productLine.id}`, productLine, {
            responseType: 'text'
        });
    }
}
