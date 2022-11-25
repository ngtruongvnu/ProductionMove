import {Injectable, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class UserService {

    private currentUser: any;

    constructor(private activatedRoute: ActivatedRoute) {
    }

    ngOnInit(): void {
    }

    getCurrentUser() {
        if (this.currentUser) {
            return this.currentUser;
        }
        const currentUser = localStorage.getItem('currentUser');
        if (currentUser) {
            this.currentUser = JSON.parse(currentUser);
            return this.currentUser;
        }
    }

    removeCurrentUser() {
        this.activatedRoute.snapshot.data = {};
        this.currentUser = null;
    }
}
