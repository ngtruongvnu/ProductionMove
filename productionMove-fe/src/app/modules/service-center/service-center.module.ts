import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServiceCenterRoutingModule } from './service-center-routing.module';
import { LayoutComponent } from './layout/layout.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzMenuModule} from "ng-zorro-antd/menu";
import {NzIconModule} from "ng-zorro-antd/icon";
import {NzAvatarModule} from "ng-zorro-antd/avatar";
import {NzDropDownModule} from "ng-zorro-antd/dropdown";
import { NeedWarrantyProductComponent } from './pages/need-warranty-product/need-warranty-product.component';
import { SendtoWarehouseServicecenterComponent } from './pages/sendto-warehouse-servicecenter/sendto-warehouse-servicecenter.component';
import { SendbackToAgentComponent } from './pages/sendback-to-agent/sendback-to-agent.component';
import {NzTableModule} from "ng-zorro-antd/table";
import {NzTabsModule} from "ng-zorro-antd/tabs";
import {NzPaginationModule} from "ng-zorro-antd/pagination";
import {NzFormModule} from "ng-zorro-antd/form";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NzButtonModule} from "ng-zorro-antd/button";
import {NzInputModule} from "ng-zorro-antd/input";
import {NzRadioModule} from "ng-zorro-antd/radio";
import {NzSelectModule} from "ng-zorro-antd/select";
import { ImpossibleFixProductComponent } from './pages/impossible-fix-product/impossible-fix-product.component';


@NgModule({
  declarations: [
    LayoutComponent,
    NeedWarrantyProductComponent,
    SendtoWarehouseServicecenterComponent,
    SendbackToAgentComponent,
    ImpossibleFixProductComponent
  ],
    imports: [
        CommonModule,
        ServiceCenterRoutingModule,
        NzLayoutModule,
        NzMenuModule,
        NzIconModule,
        NzAvatarModule,
        NzDropDownModule,
        NzTableModule,
        NzTabsModule,
        NzPaginationModule,
        NzFormModule,
        ReactiveFormsModule,
        NzButtonModule,
        NzInputModule,
        NzRadioModule,
        FormsModule,
        NzSelectModule
    ]
})
export class ServiceCenterModule { }
