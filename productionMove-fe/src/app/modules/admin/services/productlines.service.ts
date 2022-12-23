import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProductLine} from "../../../core/models/product-line.model";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ProductlinesService {
    private readonly API_URL = 'https://636135a1af66cc87dc262c92.mockapi.io/api/v1/productlines';

    constructor(private http: HttpClient) {
    }

    getProductLines(): Observable<ProductLine[]> {
        return this.http.get<ProductLine[]>(this.API_URL);
    }

    getProductLineDetail(id: number): Observable<ProductLine> {
        return this.http.get<ProductLine>(`${this.API_URL}/${id}`);
    }

    insertProductLine(productLine: ProductLine): Observable<boolean> {
        return this.http.post<boolean>(this.API_URL, productLine);
    }

    deleteProductLine(id: number): Observable<boolean> {
        return this.http.delete<boolean>(`${this.API_URL}/${id}`);
    }

    updateProductLine(productLine: ProductLine): Observable<boolean> {
        return this.http.put<boolean>(`${this.API_URL}/${productLine.id}`, productLine);
    }
}
