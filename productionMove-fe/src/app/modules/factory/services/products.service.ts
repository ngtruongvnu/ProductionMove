import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../../core/models/product.model";
import {User} from "../../../core/models/user.model";
import {ROLES} from "../../../core/constants/roles";

@Injectable({
    providedIn: 'root'
})
export class ProductsService {

    private API_URL = 'http://localhost:8087/api/v1';
    constructor(private http: HttpClient) {
    }

    getAllProducts(userId: number) : Observable<Product[]> {
        return this.http.get<Product[]>(`${this.API_URL}/factory/get-products`, {
            params: {
                user_id: userId.toString()
            }
        });
    }

    getAgentUsers() : Observable<User[]> {
        return this.http.get<User[]>(`${this.API_URL}/user/get-user-by-filter`, {
            params: {
                role: ROLES.agent,
            }
        });
    }

    sendProductsToAgent(userId: number, agentId:number, productIds: number[]) {
        return this.http.post(`${this.API_URL}/factory/send-to-agent/${userId}/${agentId}`, productIds, {
            responseType: 'text',
        });
    }
}
