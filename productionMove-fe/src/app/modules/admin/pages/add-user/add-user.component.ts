import {Component, OnInit} from '@angular/core';
import {FormBuilder, UntypedFormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../../../../core/services/user.service";
import {ROLES} from "../../../../core/constants/roles";
import {ToastrService} from "ngx-toastr";

@Component({
    selector: 'app-add-user',
    templateUrl: './add-user.component.html',
    styleUrls: ['./add-user.component.less']
})
export class AddUserComponent implements OnInit {


    roleUser = Object.keys(ROLES)
        .filter(key => isNaN(Number(key)))
        // @ts-ignore
        .map(key => ({label: this.getRole(ROLES[key]), value: ROLES[key]}));

    newUserForm !: UntypedFormGroup;
    constructor(
        private fb: FormBuilder,
        private toast: ToastrService,
        private router: Router,
        private userService: UserService,
    ) {
    }

    ngOnInit(): void {
        this.newUserForm = this.fb.group({
            username: ['', [Validators.required]],
            password: ['', [Validators.required]],
            role: ['', [Validators.required]],
            firstname: ['', [Validators.required]],
            lastname: ['', [Validators.required]],
        })
    }

    submit($event: MouseEvent) {
        $event.preventDefault();
        if (this.newUserForm.invalid) {
            Object.values(this.newUserForm.controls).forEach(control => {
                control.markAsDirty();
                control.updateValueAndValidity();
            });
            this.toast.error('Vui lòng nhập đầy đủ thông tin', "Error");
            return;
        }
    }

    getRole(role: number) {
        switch (role) {
            case 0:
                return 'Ban quản trị';
            case 1:
                return 'Cơ sở sản xuất';
            case 2:
                return 'Trung tâm bảo hành';
            default:
                return 'Đại lý';
        }
    }

}
