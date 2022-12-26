import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LayoutComponent} from "./layout/layout.component";
import {SellProductComponent} from "./pages/sell-product/sell-product.component";
import {SellProductStatisticComponent} from "./pages/sell-product-statistic/sell-product-statistic.component";
import {ImportProductComponent} from "./pages/import-product/import-product.component";
import {RecallProductComponent} from "./pages/recall-product/recall-product.component";
import {WarrantyProductComponent} from "./pages/warranty-product/warranty-product.component";
import {GivebackWarrantyProductComponent} from "./pages/giveback-warranty-product/giveback-warranty-product.component";

const routes: Routes = [
    { path: '', component: LayoutComponent, children: [
        {path: '', redirectTo: 'sell-product', pathMatch: 'full'},
        {path: 'sell-product', component: SellProductComponent},
        {path: 'sell-product-statistic', component: SellProductStatisticComponent},
        {path: 'import-product', component: ImportProductComponent},
        {path: 'recall-product', component: RecallProductComponent},
        {path: 'warranty-product', component: WarrantyProductComponent},
        {path: 'giveback-warranty-product', component: GivebackWarrantyProductComponent}
    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AgentRoutingModule { }
