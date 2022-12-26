import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Observable, Observer } from 'rxjs';

@Component({
  selector: 'app-warranty-product',
  templateUrl: './warranty-product.component.html',
  styleUrls: ['./warranty-product.component.less']
})
export class WarrantyProductComponent implements OnInit {

    validateForm: UntypedFormGroup;

    submitForm(): void {
        console.log('submit', this.validateForm.value);
    }

    resetForm(e: MouseEvent): void {
        e.preventDefault();
        this.validateForm.reset();
        for (const key in this.validateForm.controls) {
            if (this.validateForm.controls.hasOwnProperty(key)) {
                this.validateForm.controls[key].markAsPristine();
                this.validateForm.controls[key].updateValueAndValidity();
            }
        }
    }


    // eslint-disable-next-line @typescript-eslint/explicit-function-return-type
    userNameAsyncValidator = (control: UntypedFormControl) =>
        new Observable((observer: Observer<ValidationErrors | null>) => {
            setTimeout(() => {
                if (control.value === 'JasonWood') {
                    // you have to return `{error: true}` to mark it as an error event
                    observer.next({ error: true, duplicated: true });
                } else {
                    observer.next(null);
                }
                observer.complete();
            }, 1000);
        });

    // confirmValidator = (control: UntypedFormControl): { [s: string]: boolean } => {
    //     if (!control.value) {
    //         return { error: true, required: true };
    //     } else if (control.value !== this.validateForm.controls.password.value) {
    //         return { confirm: true, error: true };
    //     }
    //     return {};
    // };

    errors = [
        { name: "Lỗi túi khí", value: 0},
        { name: "Lỗi động cơ", value: 1},
        { name: "Lỗi chân ga, chân phanh", value: 2},
        { name: "Lỗi hệ thống điều khiển", value: 3},
        { name: "Lỗi khác", value: 4},
    ];

    constructor(private fb: UntypedFormBuilder) {
        this.validateForm = this.fb.group({
            productid: ['', [Validators.required], [this.userNameAsyncValidator]],
            error: ['', [Validators.required]],
            comment: ['', [Validators.required]],
            servicecenterid: ['', [Validators.required]]
        });
    }

  ngOnInit(): void {
  }

}
