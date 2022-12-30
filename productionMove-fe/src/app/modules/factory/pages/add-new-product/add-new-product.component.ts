import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProductLine} from "../../../../core/models/product-line.model";
import {ToastrService} from "ngx-toastr";
import {NzModalService} from "ng-zorro-antd/modal";
import {FormBuilder, UntypedFormGroup, Validators} from "@angular/forms";
import {WarehouseService} from "../../../../core/services/warehouse.service";
import {UserService} from "../../../../core/services/user.service";
import {Warehouse} from "../../../../core/models/warehouse.model";
import {ProductBatchesService} from "../../services/product-batches.service";
import {ProductBatchFactory} from "../../../../core/models/product-batch.model";
import {ProductLinesService} from "../../services/product-lines.service";

@Component({
    selector: 'app-add-new-product',
    templateUrl: './add-new-product.component.html',
    styleUrls: ['./add-new-product.component.less']
})
export class AddNewProductComponent implements OnInit {
    listOfColumn = [
        {
            title: 'ID lô sản phẩm',
            compare: (a: ProductBatchFactory, b: ProductBatchFactory) => a.productBatch.id - b.productBatch.id,
            priority: 1
        },
        {
            title: 'Tên dòng sản phẩm',
            compare: (a: ProductBatchFactory, b: ProductBatchFactory) => a.productlineDetail.name.localeCompare(b.productlineDetail.name),
            priority: 3,
        },
        {
            title: 'Số lượng sản phẩm',
            compare: (a: ProductBatchFactory, b: ProductBatchFactory) => a.productBatch.quantity - b.productBatch.quantity,
            priority: 2
        }
    ];
    pagesize: number = 8;
    listOfData: ProductBatchFactory[] = [];
    isLoading: boolean = false;
    formNewBatch !: UntypedFormGroup;
    warehouses: Warehouse[] = [];
    productLineList: ProductLine[] = [];

    constructor(
        private productLinesService: ProductLinesService,
        private userService: UserService,
        private warehouseService: WarehouseService,
        private productBatchService: ProductBatchesService,
        private toast: ToastrService,
        private modalService: NzModalService,
        private fb: FormBuilder,
    ) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.getProductBatches();
        this.getListProductLines();
        this.getListWarehouse();
        this.formNewBatch = this.fb.group({
            productline_id: [null, [Validators.required]],
            quantity: [null, [Validators.required]],
            place_at: [null, [Validators.required]],
            user_id: [this.userService.getCurrentUser().id, [Validators.required]],
        })
    }

    createNewProductBatch(nzContent: TemplateRef<{}>): void {
        this.modalService.create({
            nzTitle: 'Thêm mới lô sản phẩm',
            nzContent: nzContent,
            nzMaskClosable: false,
            nzClosable: false,
            nzStyle: {
                minWidth: '500px'
            },
            nzCancelText: 'Hủy',
            nzOkText: 'Đồng ý',
            nzOnOk: () => {
                this.addNewProductBatch();
                console.log(this.formNewBatch.value);
            }
        });
    }

    getProductBatches() {
        const userId = this.userService.getCurrentUser().id;
        this.productBatchService.getAllProductBatches(userId).subscribe({
            next: (data) => {
                this.listOfData = data;
                console.log(this.listOfData);
                this.toast.success('Tải thành công danh sách lô sản phẩm', 'Success');
                this.isLoading = false;
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
                this.isLoading = false;
            }
        })
    }

    getListWarehouse() {
        this.warehouseService.getWarehouses(this.userService.getCurrentUser().id).subscribe({
            next: (data) => {
                this.warehouses = data;
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
            }
        })
    }

    getListProductLines() {
        this.productLinesService.getProductLines().subscribe({
            next: (data) => {
                this.productLineList = data;
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
            }
        })
    }

    addNewProductBatch() {
        this.productBatchService.insertProductBatch(this.formNewBatch.value).subscribe({
            next: (data) => {
                this.toast.success(data, 'Success');
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
            }
        })
    }
}
