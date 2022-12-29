import {Component, OnInit} from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {NzModalService} from "ng-zorro-antd/modal";
import {Router} from "@angular/router";
import {ProductService} from "../../services/product.service";
import {Product} from "../../../../core/models/product.model";
import {PRODUCT_STATUS} from "../../../../core/constants/products";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.less']
})
export class ProductsComponent implements OnInit {
    // @ts-ignore
    listOfColumn = [
        {
            title: 'Mã sản phẩm',
            compare: (a: Product, b: Product) => a.productCode.localeCompare(b.productCode),
            priority: false
        },
        {
            title: 'Tên sản phẩm',
            compare: (a: Product, b: Product) => a.productName.localeCompare(b.productName),
            priority: false
        },
        {
            title: 'Thời gian bảo hành',
            compare: (a: Product, b: Product) => a.warrantyPeriod - b.warrantyPeriod,
            priority: 1
        },
        {
            title: 'Số lần bảo hành',
            // @ts-ignore
            compare: (a: Product, b: Product) => a?.warrantyCount - b?.warrantyCount,
            priority: 2
        },
        {
            title: 'Trạng thái',
            compare: (a: Product, b: Product) => a.status - b.status,
            priority: 3
        },
        {
            title: "Hành động",
            compare: null,
            priority: false

        }
    ];
    pagesize: number = 8;
    listOfData: Product[] = [];
    isLoading: boolean = false;
    constructor(
        private productService: ProductService,
        private toast: ToastrService,
        private modal: NzModalService,
        private router: Router
    ) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.productService.getProducts().subscribe({
            next: (data) => {
                this.listOfData = data;
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
            },
            complete: () => {
                this.toast.success('Tải thành công danh sách sản phẩm', 'Success');
                this.isLoading = false;
            }
        })
    }

    getCarStatus(status: number) {
        return PRODUCT_STATUS[status];
    }

    negative(path: string) {
        this.router.navigateByUrl(`admin/${path}`);
    }
}

