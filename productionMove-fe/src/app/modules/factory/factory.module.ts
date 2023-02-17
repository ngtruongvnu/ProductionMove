import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FactoryRoutingModule } from './factory-routing.module';
import { LayoutComponent } from './layout/layout.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzMenuModule} from "ng-zorro-antd/menu";
import {NzIconModule} from "ng-zorro-antd/icon";
import {NzAvatarModule} from "ng-zorro-antd/avatar";
import {NzDropDownModule} from "ng-zorro-antd/dropdown";
import { AddNewProductComponent } from './pages/add-new-product/add-new-product.component';
import { SendProductToAgentComponent } from './pages/send-product-to-agent/send-product-to-agent.component';
import { ReceiveProductErrorComponent } from './pages/receive-product-error/receive-product-error.component';
import { StatisticProductComponent } from './pages/statistic-product/statistic-product.component';
import { StatisticErrorProductComponent } from './pages/statistic-error-product/statistic-error-product.component';
import {NzBreadCrumbModule} from "ng-zorro-antd/breadcrumb";
import {NzCardModule} from "ng-zorro-antd/card";
import {NzTableModule} from "ng-zorro-antd/table";
import {NzModalService} from "ng-zorro-antd/modal";
import {NzButtonModule} from "ng-zorro-antd/button";
import {NzFormModule} from "ng-zorro-antd/form";
import {NzInputModule} from "ng-zorro-antd/input";
import {NzSelectModule} from "ng-zorro-antd/select";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    LayoutComponent,
    AddNewProductComponent,
    SendProductToAgentComponent,
    ReceiveProductErrorComponent,
    StatisticProductComponent,
    StatisticErrorProductComponent
  ],
    imports: [
        CommonModule,
        FactoryRoutingModule,
        NzLayoutModule,
        NzMenuModule,
        NzIconModule,
        NzAvatarModule,
        NzDropDownModule,
        NzBreadCrumbModule,
        NzCardModule,
        NzTableModule,
        NzButtonModule,
        NzFormModule,
        NzInputModule,
        NzSelectModule,
        ReactiveFormsModule
    ],
    providers: [
        NzModalService
    ]
})
export class FactoryModule { }
