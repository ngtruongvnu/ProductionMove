import {Component, OnInit} from '@angular/core';
import {UntypedFormBuilder, UntypedFormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../../core/services/auth.service";
import {Router} from "@angular/router";
import {UserService} from "../../../core/services/user.service";
import {ToastrService} from "ngx-toastr";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {
    isLoading = false;

    validateForm!: UntypedFormGroup;

    constructor(
        private fb: UntypedFormBuilder,
        private authService: AuthService,
        private router: Router,
        private userService: UserService,
        private toastify: ToastrService
    ) { }

    ngOnInit(): void {
        this.validateForm = this.fb.group({
            username: [null, [Validators.required]],
            password: [null, [Validators.required]]
        });
    }

    submitForm(): void {
        if (this.validateForm.valid) {
            this.isLoading = true;
            console.log('submit', this.validateForm.value);
            this.authService.login(this.validateForm.value).subscribe({
                next: () => {
                    console.log('success');
                    this.router.navigateByUrl(`/${this.userService.getCurrentUser().role}`);
                },
                error: (err) => {
                    this.toastify.error(err);
                    this.isLoading = false;
                },
                complete: () => {
                    this.toastify.success('Login success');
                    this.isLoading = false;
                }
            })
        } else {
            Object.values(this.validateForm.controls).forEach(control => {
                if (control.invalid) {
                    control.markAsDirty();
                    control.updateValueAndValidity({onlySelf: true});
                }
            });
        }
    }
}
