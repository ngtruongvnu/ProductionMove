import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LayoutComponent} from "./layout/layout.component";
import {NeedWarrantyProductComponent} from "./pages/need-warranty-product/need-warranty-product.component";
import {SendbackToAgentComponent} from "./pages/sendback-to-agent/sendback-to-agent.component";
import {
    SendtoWarehouseServicecenterComponent
} from "./pages/sendto-warehouse-servicecenter/sendto-warehouse-servicecenter.component";
import {ImpossibleFixProductComponent} from "./pages/impossible-fix-product/impossible-fix-product.component";

const routes: Routes = [
    { path: '', component: LayoutComponent, children: [
            {path: '', redirectTo: 'need-warranty-product', pathMatch: 'full'},
            {path: 'need-warranty-product', component: NeedWarrantyProductComponent},
            {path: 'impossible-fix-product', component: ImpossibleFixProductComponent},
            {path: 'sendback-to-agent', component: SendbackToAgentComponent},
            {path: 'sendto-warehouse-service', component: SendtoWarehouseServicecenterComponent}
        ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceCenterRoutingModule { }
