import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../services/product.service";
import {ProductDetail} from "../../../../core/models/product-detail.model";
import {ToastrService} from "ngx-toastr";
import {TYPES, CATEGORIES} from "../../../../core/constants/productlines";

@Component({
    selector: 'app-product-detail',
    templateUrl: './product-detail.component.html',
    styleUrls: ['./product-detail.component.less']
})
export class ProductDetailComponent implements OnInit {

    productDetail!: ProductDetail;
    constructor(
        private route: Router,
        private activeRoute: ActivatedRoute,
        private toast: ToastrService,
        private productService: ProductService
    ) {
    }

    ngOnInit(): void {
        const id = this.activeRoute.snapshot.params['id'];
        this.productService.getProductDetail(id).subscribe({
            next: (result) => {
                this.productDetail = result;
                this.toast.success('Tải thành công dữ liệu chi tiết sản phẩm', 'Success');
            },
            error: (error) => {
                this.toast.error(error, 'Error');
            }
        })
    }

    back() {
        this.route.navigateByUrl('/admin/products');
    }

    getCardType(type: number) {
        return TYPES[type];
    }

    getCarCategory(category: number) {
        return CATEGORIES[category];
    }
}
