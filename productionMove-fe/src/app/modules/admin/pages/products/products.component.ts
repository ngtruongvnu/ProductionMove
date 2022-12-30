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
            title: 'ID sản phẩm',
            compare: (a: Product, b: Product) => a.product_id - b.product_id,
            priority: 1
        },
        {
            title: 'Mã sản phẩm',
            compare: (a: Product, b: Product) => a.product_code.localeCompare(b.product_code),
            priority: 2
        },
        {
            title: 'Tên sản phẩm',
            compare: (a: Product, b: Product) => a.product_name.localeCompare(b.product_name),
            priority: 3
        },
        {
            title: 'Số lần bảo hành',
            compare: (a: Product, b: Product) => a.so_lan_bao_hanh - b.so_lan_bao_hanh,
            priority: 4
        },
        {
            title: 'Trạng thái',
            compare: (a: Product, b: Product) => a.product_status - b.product_status,
            priority: 5
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

