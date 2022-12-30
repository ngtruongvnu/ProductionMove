import {Component, OnInit} from '@angular/core';
import {Product} from "../../../../core/models/product.model";
import {ProductBatch} from "../../../../core/models/product-batch.model";
import {ProductsService} from "../../services/products.service";
import {NzModalService} from "ng-zorro-antd/modal";

@Component({
    selector: 'app-receive-product-error',
    templateUrl: './receive-product-error.component.html',
    styleUrls: ['./receive-product-error.component.less']
})
export class ReceiveProductErrorComponent implements OnInit {
    listOfColumn = [
        {
            title: 'Mã sản phẩm',
            compare: (a: Product, b: Product) => a.product_code.localeCompare(b.product_code),
            priority: 1
        },
        {
            title: 'Lô sản phẩm',
            compare: (a: Product, b: Product) => a.productBatchId - b.productBatchId,
            priority: 2
        },
        {
            title: 'Tên dòng sản phẩm',
            compare: (a: Product, b: Product) => a.product_name.localeCompare(b.product_name),
            priority: 3,
        },
        {
            title: "Địa điểm lưu trữ",
            compare: (a: Product, b: Product) => a.place.localeCompare(b.place),
            priority: 4,
        }
    ];
    pagesize: number = 6;
    isLoading: boolean = false;
    listOfData: Product[] = [];

    constructor(
        private productsService: ProductsService,
        private nzModal: NzModalService,
    ) {
    }

    ngOnInit(): void {
    }

}
