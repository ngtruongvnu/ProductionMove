import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../../../core/models/product.model";
import {Observable} from "rxjs";
import {ProductDetail} from "../../../core/models/product-detail.model";

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    private readonly API_URL = 'https://636135a1af66cc87dc262c92.mockapi.io/api/v1/products';
    constructor(private http: HttpClient) {
    }

    getProducts() : Observable<Product[]> {
        return this.http.get<Product[]>(this.API_URL);
    }

    getProductDetail(id: number) : Observable<ProductDetail> {
        return this.http.get<ProductDetail>(`${this.API_URL}/${id}`);
    }
}
