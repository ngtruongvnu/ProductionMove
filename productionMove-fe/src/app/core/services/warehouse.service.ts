import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Warehouse} from "../models/warehouse.model";

@Injectable({
    providedIn: 'root'
})
export class WarehouseService {

    constructor(
        private http: HttpClient
    ) {
    }

    getWarehouses(userId: number) : Observable<Warehouse[]> {
        return this.http.get<Warehouse[]>(`http://localhost:8080/api/warehouse/${userId}`);
    }

}
