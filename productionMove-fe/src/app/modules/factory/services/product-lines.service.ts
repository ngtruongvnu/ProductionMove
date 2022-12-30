import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductLine} from "../../../core/models/product-line.model";

@Injectable({
    providedIn: 'root'
})
export class ProductLinesService {

    private API_URL = 'http://localhost:8087/api/v1/productline';
    constructor(
        private http: HttpClient
    ) {
    }

    getProductLines() : Observable<ProductLine[]> {
        return this.http.get<ProductLine[]>(`${this.API_URL}/get-all`);
    }
}
