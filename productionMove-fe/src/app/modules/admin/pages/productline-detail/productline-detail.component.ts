import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, UntypedFormGroup} from "@angular/forms";
import {ProductLine} from "../../../../core/models/product-line.model";
import {ProductlinesService} from "../../services/productlines.service";
import {ToastrService} from "ngx-toastr";
import {TYPES, CATEGORIES} from "../../../../core/constants/productlines";
import {tap} from "rxjs";
import {NzModalService} from "ng-zorro-antd/modal";

@Component({
    selector: 'app-productline-detail',
    templateUrl: './productline-detail.component.html',
    styleUrls: ['./productline-detail.component.less']
})
export class ProductlineDetailComponent implements OnInit {

    productLineForm !: UntypedFormGroup;
    productLineDetail !: ProductLine;
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
    canSave: boolean = false;

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
        this.getProductLineDetail();
        this.productLineForm = this.fb.group({
            id: [{disabled: !this.canSave, value: null}],
            name: [{disabled: !this.canSave, value: null}],
            type: [{disabled: !this.canSave, value: null}],
            categoryCar: [{disabled: !this.canSave, value: null}],
            lenght: [{disabled: !this.canSave, value: null}],
            width: [{disabled: !this.canSave, value: null}],
            power: [{disabled: !this.canSave, value: null}],
            displacement: [{disabled: !this.canSave, value: null}],
            gearbox: [{disabled: !this.canSave, value: null}],
            seats: [{disabled: !this.canSave, value: null}],
            engine: [{disabled: !this.canSave, value: null}],
            imgUrl: [{disabled: !this.canSave, value: null}],
            description: [{disabled: !this.canSave, value: null}],
            createdDate: [{disabled: !this.canSave, value: null}],
            createdBy: [{disabled: !this.canSave, value: null}],
            modifiedDate: [{disabled: !this.canSave, value: null}],
            modifiedBy: [{disabled: !this.canSave, value: null}],
        });
    }

    private getProductLineDetail() {
        const id = this.routerActive.snapshot.params['id'];
        this.productLinesService.getProductLineDetail(id)
            .pipe(tap(productLineDetail => this.productLineForm.patchValue(productLineDetail)))
            .subscribe({
                next: (data) => {
                    this.productLineDetail = data;
                    this.toast.success('Tải thành công dữ liệu chi tiết dòng sản pẩm', 'Success');
                },
                error: (err) => {
                    this.toast.error(err.message, 'Error');
                }
            })
    }

    back() {
        this.router.navigateByUrl('/admin/product-lines');
    }

    //todo: unable save button
    unableSave(event: MouseEvent) {
        event.preventDefault();
        this.canSave = !this.canSave;
        const controls = this.productLineForm.controls;
        Object.keys(controls).forEach((key) => {
            controls[key].enable();
        })
    }

    //todo: save product line and unable update button
    save() {
        this.canSave = !this.canSave;
        const controls = this.productLineForm.controls;
        Object.keys(controls).forEach((key) => {
            controls[key].disable();
        })
        this.updateProductDetail();
    }
    updateProductDetail() {
        this.productLinesService.updateProductLine(this.productLineForm.value).subscribe({
            next: (data) => {
                this.toast.success('Cập nhật thành công dòng sản phẩm', 'Success');
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
            }
        })
    }
    delete(event: MouseEvent) {
        event.preventDefault();
        this.nzModalService.confirm({
            nzTitle: 'Bạn có chắc chắn muốn xóa dòng sản phẩm này?',
            nzContent: 'Dòng sản phẩm này sẽ bị xóa khỏi hệ thống',
            nzOkText: 'Xóa',
            nzCancelText: 'Hủy',
            nzOkDanger: true,
            nzAutofocus: "ok",
            nzOnOk: () => {
                this.productLinesService.deleteProductLine(this.productLineForm.value.id).subscribe({
                    next: (data) => {
                        this.toast.success('Xóa thành công dòng sản phẩm', 'Success');
                        this.back();
                    },
                    error: (err) => {
                        this.toast.error(err.message, 'Error');
                    }
                })
            }

        })
    }

}
