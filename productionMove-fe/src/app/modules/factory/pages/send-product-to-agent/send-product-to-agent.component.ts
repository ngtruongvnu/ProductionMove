import {Component, OnInit} from '@angular/core';
import {ProductBatch} from "../../../../core/models/product-batch.model";
import {Product} from "../../../../core/models/product.model";
import {ProductsService} from "../../services/products.service";
import {NzModalService} from "ng-zorro-antd/modal";

@Component({
    selector: 'app-send-product-to-agent',
    templateUrl: './send-product-to-agent.component.html',
    styleUrls: ['./send-product-to-agent.component.less']
})
export class SendProductToAgentComponent implements OnInit {
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
