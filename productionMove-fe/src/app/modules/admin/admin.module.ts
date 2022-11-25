import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { LayoutComponent } from './layout/layout.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzMenuModule} from "ng-zorro-antd/menu";
import {NzIconModule} from "ng-zorro-antd/icon";
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import {NzAvatarModule} from "ng-zorro-antd/avatar";
import {NzPopoverModule} from "ng-zorro-antd/popover";
import {NzDropDownModule} from "ng-zorro-antd/dropdown";

@NgModule({
  declarations: [
    LayoutComponent,
    DashboardComponent
  ],
    imports: [
        CommonModule,
        AdminRoutingModule,
        NzLayoutModule,
        NzMenuModule,
        NzIconModule,
        NzAvatarModule,
        NzPopoverModule,
        NzDropDownModule
    ]
})
export class AdminModule { }
