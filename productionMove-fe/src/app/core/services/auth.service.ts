import {Injectable} from '@angular/core';
import {Observable, of, throwError} from "rxjs";
import {UserService} from "./user.service";

interface ILoginContext {
    username: string;
    password: string;
}

interface IUserInfo {
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    token: string;
    role: string;
    id: string;
}

const defaultUser : IUserInfo = {
    username: "tuanvu",
    password: "123456",
    firstName: 'Tuan',
    lastName: "Vu",
    token: "123456789",
    role: "service-center",
    id: "123"
}



@Injectable({
    providedIn: 'root'
})
export class AuthService {
    token: string = '';

    constructor(private userService : UserService) {
    }

    login(loginContext: ILoginContext) : Observable<IUserInfo> {
        const isDefaultUser = loginContext.username === defaultUser.username && loginContext.password === defaultUser.password;
        if (isDefaultUser) {
            localStorage.setItem('currentUser', JSON.stringify(defaultUser));
            return of(defaultUser);
        }

        return throwError('Invalid username or password');
    }

    logout() : Observable<boolean> {
        localStorage.removeItem('currentUser');
        this.userService.removeCurrentUser();
        return of(false);
    }

}
