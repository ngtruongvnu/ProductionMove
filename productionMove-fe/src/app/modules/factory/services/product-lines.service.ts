import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductLine} from "../../../core/models/product-line.model";

@Injectable({
    providedIn: 'root'
})
export class ProductLinesService {

    constructor(
        private http: HttpClient
    ) {
    }

    getProductLines() : Observable<ProductLine[]> {
        return this.http.get<ProductLine[]>('https://636135a1af66cc87dc262c92.mockapi.io/api/v1/productlines');
    }
}
