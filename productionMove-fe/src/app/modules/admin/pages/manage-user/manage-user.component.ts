import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProductLine} from "../../../../core/models/product-line.model";
import {ProductlinesService} from "../../services/productlines.service";
import {ToastrService} from "ngx-toastr";
import {NzModalService} from "ng-zorro-antd/modal";
import {Router} from "@angular/router";
import {CATEGORIES, TYPES} from "../../../../core/constants/productlines";
import {User} from "../../../../core/models/user.model";
import {UsersService} from "../../services/users.service";

@Component({
  selector: 'app-manage-user',
  templateUrl: './manage-user.component.html',
  styleUrls: ['./manage-user.component.less']
})
export class ManageUserComponent implements OnInit {

    listOfColumn = [
        {
            title: 'ID cơ sở',
            compare: (a: User, b: User) => a.id - b.id,
            priority: false,
        },
        {
            title: 'Username',
            compare: (a: User, b: User) => a.user_name.localeCompare(b.user_name),
            priority: 3
        },
        {
            title: 'Họ, tên chủ cơ sở',
            compare: (a: User, b: User) => (a.firstName + a.lastName).localeCompare(b.firstName + b.lastName),
            priority: 2
        },
        {
            title: 'Vai trò',
            compare: (a: User, b: User) => a.role - b.role,
            priority: 1
        },
        {
            title: "Hành động",
            compare: null,
            priority: false

        }
    ];
    pagesize: number = 8;
    listOfData: User[] = [];
    isLoading: boolean = false;
    address: string = '';
    visible = false;
    constructor(
        private productLinesService: ProductlinesService,
        private userService: UsersService,
        private toast: ToastrService,
        private modal: NzModalService,
        private router: Router
    ) {
    }

    ngOnInit(): void {
        this.isLoading = true;
        this.userService.getAllUsers().subscribe({
            next: (data) => {
                this.listOfData = data;
            },
            error: (err) => {
                this.toast.error(err.message, 'Error');
            },
            complete: () => {
                this.toast.success('Tải thành công dữ liệu thành viên hệ thống', 'Success');
                this.isLoading = false;
            }
        })
    }

    addNewWarehouse(nzContent: TemplateRef<{}>, userId: number, username: string) {
        this.modal.create({
            nzTitle: 'Thêm mới kho hàng',
            nzContent: nzContent,
            nzComponentParams: {
                userId: userId,
                username: username
            },
            nzOkText: 'Đồng ý',
            nzCancelText: 'Hủy',
            nzOnOk: () => {
                if (this.address) {
                    this.userService.addNewWarehouse({
                        user_id: userId,
                        address: this.address
                    }).subscribe({
                        next: (data) => {
                            this.toast.success('Thêm mới cơ sở thành công', 'Success');
                            this.address = '';
                        },
                        error: (err) => {
                            this.toast.error(err.message, 'Error');
                        }
                    })
                } else {
                    this.toast.error('Vui lòng nhập địa chỉ cơ sở', 'Error');
                }
            }
        })
    }

    negative(path: string) {
        this.router.navigateByUrl(`admin/${path}`);
    }

    getFullName(firstName: string, lastName: string) {
        return firstName + ' ' + lastName;
    }

    getRole(role: number) {
        switch (role) {
            case 0:
                return 'Ban quản lý';
            case 1:
                return 'Cơ sở sản xuất';
            case 2:
                return 'Trung tâm bảo hành';
            default:
                return 'Đại lý';
        }
    }
}
