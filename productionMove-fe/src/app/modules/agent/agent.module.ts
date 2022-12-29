import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgentRoutingModule } from './agent-routing.module';
import { LayoutComponent } from './layout/layout.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzMenuModule} from "ng-zorro-antd/menu";
import {NzIconModule} from "ng-zorro-antd/icon";
import {NzAvatarModule} from "ng-zorro-antd/avatar";
import {NzDropDownModule} from "ng-zorro-antd/dropdown";
import { ImportProductComponent } from './pages/import-product/import-product.component';
import { SellProductComponent } from './pages/sell-product/sell-product.component';
import { SellProductStatisticComponent } from './pages/sell-product-statistic/sell-product-statistic.component';
import { WarrantyProductComponent } from './pages/warranty-product/warranty-product.component';
import { GivebackWarrantyProductComponent } from './pages/giveback-warranty-product/giveback-warranty-product.component';
import { RecallProductComponent } from './pages/recall-product/recall-product.component';
import {NzFormModule} from "ng-zorro-antd/form";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NzInputModule} from "ng-zorro-antd/input";
import {NzSelectModule} from "ng-zorro-antd/select";
import {NzButtonModule} from "ng-zorro-antd/button";
import {NzCheckboxModule} from "ng-zorro-antd/checkbox";
import {NzDatePickerModule} from "ng-zorro-antd/date-picker";
import {NzTimePickerModule} from "ng-zorro-antd/time-picker";
import {NzDividerModule} from "ng-zorro-antd/divider";
import {NzTableModule} from "ng-zorro-antd/table";
import {NzRadioModule} from "ng-zorro-antd/radio";
import {NzCascaderModule} from "ng-zorro-antd/cascader";
import {NzListModule} from "ng-zorro-antd/list";
import {NzSkeletonModule} from "ng-zorro-antd/skeleton";
import {NzSpinModule} from "ng-zorro-antd/spin";
import { ImpossibleFixProductComponent } from './pages/impossible-fix-product/impossible-fix-product.component';
import { NotificationCustomerComponent } from './pages/notification-customer/notification-customer.component';
import { ReceiveFromServicecenterComponent } from './pages/receive-from-servicecenter/receive-from-servicecenter.component';
import { RecallByBatchComponent } from './pages/recall-by-batch/recall-by-batch.component';
import { SendToWarehouseServicecenterComponent } from './pages/send-to-warehouse-servicecenter/send-to-warehouse-servicecenter.component';


@NgModule({
  declarations: [
    LayoutComponent,
    ImportProductComponent,
    SellProductComponent,
    SellProductStatisticComponent,
    WarrantyProductComponent,
    GivebackWarrantyProductComponent,
    RecallProductComponent,
    ImpossibleFixProductComponent,
    NotificationCustomerComponent,
    ReceiveFromServicecenterComponent,
    RecallByBatchComponent,
    SendToWarehouseServicecenterComponent
  ],
    imports: [
        CommonModule,
        AgentRoutingModule,
        NzLayoutModule,
        NzMenuModule,
        NzIconModule,
        NzAvatarModule,
        NzDropDownModule,
        NzFormModule,
        ReactiveFormsModule,
        NzInputModule,
        NzSelectModule,
        NzButtonModule,
        NzCheckboxModule,
        NzDatePickerModule,
        NzTimePickerModule,
        NzDividerModule,
        NzTableModule,
        NzRadioModule,
        FormsModule,
        NzCascaderModule,
        NzListModule,
        NzSkeletonModule,
        NzSpinModule
    ]
})
export class AgentModule { }
