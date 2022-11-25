import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../../core/services/user.service";
import {AuthService} from "../../../core/services/auth.service";

@Component({
    selector: 'app-layout',
    templateUrl: './layout.component.html',
    styleUrls: ['./layout.component.less']
})
export class LayoutComponent implements OnInit {
    isCollapsed = false;

    currentUser: any;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private userService: UserService, private authService: AuthService) {
    }

    ngOnInit(): void {
        console.log(this.activatedRoute.snapshot.data);
        this.currentUser = this.activatedRoute.snapshot.data;
    }

    logout() {
        this.authService.logout().subscribe({
            next: () => {
                this.router.navigateByUrl('/login');
                this.currentUser = null;
            }
        })
    }

}
