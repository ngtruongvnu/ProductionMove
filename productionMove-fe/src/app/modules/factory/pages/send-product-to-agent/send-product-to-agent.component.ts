import {Component, OnInit} from '@angular/core';
import {ProductBatch} from "../../../../core/models/product-batch.model";
import {Product} from "../../../../core/models/product.model";
import {ProductsService} from "../../services/products.service";
import {NzModalService} from "ng-zorro-antd/modal";
import {UserService} from "../../../../core/services/user.service";
import {ToastrService} from "ngx-toastr";
import {User} from "../../../../core/models/user.model";

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
            title: 'Mã dòng sản phẩm',
            compare: (a: Product, b: Product) => a.productDetailId - b.productDetailId,
            priority: 3,
        },
        {
            title: "Thời gian bảo hành",
            compare: (a: Product, b: Product) => a.warrantyPeriod - b.warrantyPeriod,
            priority: 4,
        }
    ];
    pagesize: number = 6;
    isLoading: boolean = false;
    listOfData: Product[] = [];
    indeterminate = false;
    checked = false;
    setOfCheckedId = new Set<number>();

    listOfAgentUser: User[] = [];
    agentUserId: number = -1;

    constructor(
        private productsService: ProductsService,
        private nzModal: NzModalService,
        private userService: UserService,
        private toast: ToastrService
    ) {
    }

    ngOnInit(): void {
        this.getProducts();
        this.getAgentUsers();
    }

    getProducts() {
        this.isLoading = true;
        this.productsService.getAllProducts(this.userService.getCurrentUser().id).subscribe({
        next: (data) => {
            this.listOfData = data;
            this.isLoading = false;
        },
        error: (error) => {
            this.toast.error(error, "Error");
            this.isLoading = false;
        }
    })
    }

    getAgentUsers() {
        this.productsService.getAgentUsers().subscribe({
            next: (data) => {
                this.listOfAgentUser = data;
            },
            error: (error) => {
                this.toast.error(error, "Error");
            }
        })
    }

    updateCheckedSet(id: number, checked: boolean): void {
        if (checked) {
            this.setOfCheckedId.add(id);
        } else {
            this.setOfCheckedId.delete(id);
        }
    }

    sendProductToAgent() {
        const dataId = [...this.setOfCheckedId];
        console.log(dataId.length);
        if (dataId.length === 0 || this.agentUserId < 0) {
            this.toast.error("Vui lòng chọn sản phẩm và đại lý", "Error");
            return;
        }
        this.productsService.sendProductsToAgent(
            this.userService.getCurrentUser().id,
            this.agentUserId, dataId).subscribe({
            next: (data) => {
                this.toast.success(`Xuất kho thành công ${dataId.length} sản phẩm`, "Success");
                this.getProducts();
            },
            error: (error) => {
                this.toast.error(error.error, "Error");
            }
        })
    }
}


