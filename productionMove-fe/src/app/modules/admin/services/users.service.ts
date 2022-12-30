import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../../../core/models/user.model";

@Injectable({
    providedIn: 'root'
})
export class UsersService {

    private API_URL = 'http://localhost:8087/api/v1';
    constructor(
        private http: HttpClient
    ) {
    }

    getAllUsers() : Observable<User[]> {
        return this.http.get<User[]>(`${this.API_URL}/user/get-all`);
    }

    addNewWarehouse(warehouse: any) {
        return this.http.post(`${this.API_URL}/warehouse/insert-warehouse`, warehouse, {
            responseType: 'text'
        });
    }
}
