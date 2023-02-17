import {Injectable} from "@angular/core";
import {
    ActivatedRouteSnapshot,
    CanActivate,
    Router,
    RouterStateSnapshot,
    UrlTree
} from '@angular/router';
import {Observable} from "rxjs";
import {UserService} from "../services/user.service";

@Injectable()
export class AuthGuard implements CanActivate {
    constructor(private userService : UserService, private router: Router) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):
        Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
        const role = state.url.split('/')[1];
        const currentUser = this.userService.getCurrentUser();
        console.log(currentUser, role);
        if (!currentUser) {
            state.url = '/login';
            this.router.navigateByUrl(state.url);
        }
        if (currentUser && currentUser.role === role) {
            route.data = currentUser;
            return true;
        }
        return false;
    }
}
