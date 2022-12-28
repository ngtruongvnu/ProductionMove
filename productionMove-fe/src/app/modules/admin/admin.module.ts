import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { LayoutComponent } from './layout/layout.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzMenuModule} from "ng-zorro-antd/menu";
import {NzIconModule} from "ng-zorro-antd/icon";
import {NzAvatarModule} from "ng-zorro-antd/avatar";
import {NzPopoverModule} from "ng-zorro-antd/popover";
import {NzDropDownModule} from "ng-zorro-antd/dropdown";
import {NzBreadCrumbModule} from "ng-zorro-antd/breadcrumb";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NzAutocompleteModule} from "ng-zorro-antd/auto-complete";
import { ProductLinesComponent } from './pages/product-lines/product-lines.component';
import { ProductsComponent } from './pages/products/products.component';
import { ProductStatisticsComponent } from './pages/product-statistics/product-statistics.component';
import { ManageUserComponent } from './pages/manage-user/manage-user.component';
import { AddUserComponent } from './pages/add-user/add-user.component';
import {NzCardModule} from "ng-zorro-antd/card";
import {NzTableModule} from "ng-zorro-antd/table";
import {NzButtonModule} from "ng-zorro-antd/button";
import {NzModalModule, NzModalService} from "ng-zorro-antd/modal";
import { ProductlineDetailComponent } from './pages/productline-detail/productline-detail.component';
import {NzFormModule} from "ng-zorro-antd/form";
import {NzInputModule} from "ng-zorro-antd/input";
import {NzSelectModule} from "ng-zorro-antd/select";
import { NewProductlineComponent } from './pages/new-productline/new-productline.component';
import { ProductDetailComponent } from './pages/product-detail/product-detail.component';

@NgModule({
  declarations: [
    LayoutComponent,
    ProductLinesComponent,
    ProductsComponent,
    ProductStatisticsComponent,
    ManageUserComponent,
    AddUserComponent,
    ProductlineDetailComponent,
    NewProductlineComponent,
    ProductDetailComponent,
  ],
    imports: [
        CommonModule,
        AdminRoutingModule,
        NzLayoutModule,
        NzMenuModule,
        NzIconModule,
        NzAvatarModule,
        NzPopoverModule,
        NzDropDownModule,
        NzBreadCrumbModule,
        FormsModule,
        NzAutocompleteModule,
        NzCardModule,
        NzTableModule,
        NzButtonModule,
        NzFormModule,
        ReactiveFormsModule,
        NzInputModule,
        NzSelectModule,
    ],
    providers: [
        NzModalService
    ]
})
export class AdminModule { }
