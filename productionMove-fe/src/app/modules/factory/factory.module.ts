import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FactoryRoutingModule } from './factory-routing.module';
import { LayoutComponent } from './layout/layout.component';
import {NzLayoutModule} from "ng-zorro-antd/layout";
import {NzMenuModule} from "ng-zorro-antd/menu";
import {NzIconModule} from "ng-zorro-antd/icon";
import {NzAvatarModule} from "ng-zorro-antd/avatar";
import {NzDropDownModule} from "ng-zorro-antd/dropdown";


@NgModule({
  declarations: [
    LayoutComponent
  ],
    imports: [
        CommonModule,
        FactoryRoutingModule,
        NzLayoutModule,
        NzMenuModule,
        NzIconModule,
        NzAvatarModule,
        NzDropDownModule
    ]
})
export class FactoryModule { }
