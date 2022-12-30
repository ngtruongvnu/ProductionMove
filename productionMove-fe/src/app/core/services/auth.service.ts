import {Injectable} from '@angular/core';
import {map, Observable, of, throwError} from "rxjs";
import {UserService} from "./user.service";
import {HttpClient} from "@angular/common/http";

interface ILoginContext {
    username: string;
    password: string;
}

interface IUserInfo {
    username: string;
    firstName: string;
    lastName: string;
    token: string;
    role: number;
    id: string;
}

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    token: string = '';
    private API_URL = 'http://localhost:8087/api/v1/user/login';

    constructor(
        private userService : UserService,
        private http : HttpClient
    ) {
    }

    login(loginContext: ILoginContext) {

        return this.http.post<IUserInfo>(this.API_URL, loginContext);
    }

    logout() : Observable<boolean> {
        localStorage.removeItem('currentUser');
        this.userService.removeCurrentUser();
        return of(false);
    }

}
