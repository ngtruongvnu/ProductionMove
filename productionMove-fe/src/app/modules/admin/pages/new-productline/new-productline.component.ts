import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, UntypedFormGroup, Validator, Validators} from "@angular/forms";
import {ProductlinesService} from "../../services/productlines.service";
import {ToastrService} from "ngx-toastr";
import {TYPES, CATEGORIES} from "../../../../core/constants/productlines";
import {NzModalService} from "ng-zorro-antd/modal";

@Component({
  selector: 'app-new-productline',
  templateUrl: './new-productline.component.html',
  styleUrls: ['./new-productline.component.less']
})
export class NewProductlineComponent implements OnInit {
    productLineForm !: UntypedFormGroup;
    carType = Object.keys(TYPES).filter((key) => isNaN(Number(key))).map((key) => {
        return {
            label: key,
            // @ts-ignore
            value: TYPES[key]
        }
    });
    carCategories = Object.keys(CATEGORIES).filter((key) => isNaN(Number(key))).map((key) => {
        return {
            label: key,
            // @ts-ignore
            value: CATEGORIES[key]
        }
    });
    private isChange: boolean = false;
    public saved: boolean = false;

    constructor(
        private router: Router,
        private routerActive: ActivatedRoute,
        private fb: FormBuilder,
        private productLinesService: ProductlinesService,
        private toast: ToastrService,
        private nzModalService: NzModalService
    ) {
    }


    ngOnInit(): void {
        this.productLineForm = this.fb.group({
            name: [null, [Validators.required]],
            type: [null, [Validators.required]],
            categoryCar: [null, [Validators.required]],
            length: [null, [Validators.required]],
            width: [null, [Validators.required]],
            power: [null, [Validators.required]],
            momentum: [null, [Validators.required]],
            gearbox: [null, [Validators.required]],
            seats: [null, [Validators.required]],
            engine: [null, [Validators.required]],
            imgUrl: [null, []],
            description: [null, []],
        });
    }

    ngDoCheck() {
        this.isChange = this.productLineForm.dirty;
    }

    //todo: back to product line list
    back() {
        this.router.navigateByUrl('/admin/product-lines');
    }

    //todo: show modal confirm, if ok then back to product line list
    cancelInsert(event: MouseEvent) {
        event.preventDefault();
        if (this.isChange && !this.saved) {
            this.nzModalService.confirm({
                nzTitle: 'Bạn có chắc chắn muốn hủy thêm mới danh mục sản phẩm này?',
                nzContent: 'Danh mục sản phẩm này sẽ không được lưu lại',
                nzOkText: 'Đồng ý',
                nzCancelText: 'Hủy',
                nzOkDanger: true,
                nzAutofocus: "cancel",
                nzOnOk: () => {
                    this.back();
                }
            });
        } else {
            this.back();
        }
    }

    //todo: insert product line and disable form
    save(event: MouseEvent) {
        event.preventDefault();
        if (this.productLineForm.valid) {
            this.insertProductLine();
            const controls = this.productLineForm.controls;
            Object.keys(controls).forEach(key => {
                controls[key].disable();
            });
        } else {
            Object.values(this.productLineForm.controls).forEach(control => {
                control.markAsDirty();
                control.updateValueAndValidity();
            });
            this.toast.error('Vui lòng kiểm tra lại thông tin', "Error");
        }
    }

    //todo: insert product line
    insertProductLine() {
        this.productLinesService.insertProductLine(this.productLineForm.value).subscribe({
            next: (res) => {
                this.saved = true;
                this.toast.success('Thêm mới danh mục sản phẩm thành công', "Success");
            },
            error: (err) => {
                this.toast.error(err, "Error");
            }
        });
    }

}

