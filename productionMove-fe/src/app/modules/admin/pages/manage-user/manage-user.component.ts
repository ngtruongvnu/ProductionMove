import { Component, OnInit } from '@angular/core';
import {ProductLine} from "../../../../core/models/product-line.model";
import {ProductlinesService} from "../../services/productlines.service";
import {ToastrService} from "ngx-toastr";
import {NzModalService} from "ng-zorro-antd/modal";
import {Router} from "@angular/router";
import {CATEGORIES, TYPES} from "../../../../core/constants/productlines";

@Component({
  selector: 'app-manage-user',
  templateUrl: './manage-user.component.html',
  styleUrls: ['./manage-user.component.less']
})
export class ManageUserComponent implements OnInit {

    listOfColumn = [
        {
            title: 'Tên dòng sản phẩm',
            compare: (a: ProductLine, b: ProductLine) => a.name.localeCompare(b.name),
            priority: false,
        },
        {
            title: 'Loại xe',
            compare: (a: ProductLine, b: ProductLine) => a.type - b.type,
            priority: 3
        },
        {
            title: 'Phân khúc xe',
            compare: (a: ProductLine, b: ProductLine) => a.categoryCar - b.categoryCar,
            priority: 2
        },
        {
            title: 'Model động cơ',
            compare: (a: ProductLine, b: ProductLine) => a.engine.localeCompare(b.engine),
            priority: 1
        },
        {
            title: "Hành động",
            compare: null,
            priority: false

        }
    ];
    pagesize: number = 8;
    listOfData: ProductLine[] = [];
    isLoading: boolean = false;
    constructor(
        private productLinesService: ProductlinesService,
        private toast: ToastrService,
        private modal: NzModalService,
        private router: Router
    ) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.productLinesService.getProductLines().subscribe({
            next: (data) => {
                this.listOfData = data;
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
            },
            complete: () => {
                this.toast.success('Tải thành công danh mục dòng sản phẩm', 'Success');
                this.isLoading = false;
            }
        })
    }

    getCarType(type: number): string {
        return TYPES[type];
    }

    getCarCategory(category: number): string {
        return CATEGORIES[category];
    }

    negative(path: string) {
        this.router.navigateByUrl(`admin/${path}`);
    }

    onDelete(id: number) {
        this.modal.confirm({
            nzTitle: 'Bạn có chắc chắn muốn xóa dòng sản phẩm này không?',
            nzContent: 'Dòng sản phẩm này sẽ bị xóa khỏi hệ thống',
            nzOkText: 'Xóa',
            nzAutofocus: "ok",
            nzCancelText: 'Hủy',
            nzOkDanger: true,
            nzOnOk: () => {
                this.productLinesService.deleteProductLine(id).subscribe({
                    next: (data) => {
                        if ( data) {
                            this.listOfData = this.listOfData.filter((item) => item.id !== id);
                            this.toast.success('Xóa thành công dòng sản phẩm', 'Success');
                        } else {
                            this.toast.error('Xóa dòng sản phẩm không thành công', 'Error');
                        }
                    },
                    error: (err) => {
                        this.toast.error(err.message, 'Error');
                    }
                })
            }
        })
    }
}
