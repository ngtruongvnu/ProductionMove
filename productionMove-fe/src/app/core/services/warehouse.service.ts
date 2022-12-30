import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Warehouse} from "../models/warehouse.model";

@Injectable({
    providedIn: 'root'
})
export class WarehouseService {

    private API_URL = 'http://localhost:8087/api/v1/warehouse';
    constructor(
        private http: HttpClient
    ) {
    }

    getWarehouses(userId: number) : Observable<Warehouse[]> {
        return this.http.get<Warehouse[]>(`${this.API_URL}/get-all`, {
            params: {
                user_id: userId.toString()
            }
        });
    }

}
