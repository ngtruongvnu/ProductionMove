import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-impossible-fix-product',
  templateUrl: './impossible-fix-product.component.html',
  styleUrls: ['./impossible-fix-product.component.less']
})
export class ImpossibleFixProductComponent implements OnInit {

    selectedValue = null;
    validateForm!: UntypedFormGroup;
    listOfControl: Array<{ id: number; controlInstance: string }> = [];

    addField(e?: MouseEvent): void {
        if (e) {
            e.preventDefault();
        }
        const id = this.listOfControl.length > 0 ? this.listOfControl[this.listOfControl.length - 1].id + 1 : 0;

        const control = {
            id,
            controlInstance: `passenger${id}`
        };
        const index = this.listOfControl.push(control);
        console.log(this.listOfControl[this.listOfControl.length - 1]);
        this.validateForm.addControl(
            this.listOfControl[index - 1].controlInstance,
            new UntypedFormControl(null, Validators.required)
        );
    }

    removeField(i: { id: number; controlInstance: string }, e: MouseEvent): void {
        e.preventDefault();
        if (this.listOfControl.length > 1) {
            const index = this.listOfControl.indexOf(i);
            this.listOfControl.splice(index, 1);
            console.log(this.listOfControl);
            this.validateForm.removeControl(i.controlInstance);
        }
    }

    submitForm(): void {
        if (this.validateForm.valid) {
            console.log('submit', this.validateForm.value);
        } else {
            Object.values(this.validateForm.controls).forEach(control => {
                if (control.invalid) {
                    control.markAsDirty();
                    control.updateValueAndValidity({ onlySelf: true });
                }
            });
        }
    }

    constructor(private fb: UntypedFormBuilder) {}

    ngOnInit(): void {
        this.validateForm = this.fb.group({});
        this.addField();
    }

}
