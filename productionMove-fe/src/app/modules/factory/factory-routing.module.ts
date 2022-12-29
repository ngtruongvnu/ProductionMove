import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LayoutComponent} from "./layout/layout.component";
import {AddNewProductComponent} from "./pages/add-new-product/add-new-product.component";
import {ReceiveProductErrorComponent} from "./pages/receive-product-error/receive-product-error.component";
import {SendProductToAgentComponent} from "./pages/send-product-to-agent/send-product-to-agent.component";
import {StatisticProductComponent} from "./pages/statistic-product/statistic-product.component";
import {StatisticErrorProductComponent} from "./pages/statistic-error-product/statistic-error-product.component";

const routes: Routes = [
    {
        path: '', component: LayoutComponent, children: [
            {path: '', redirectTo: 'add-new-product', pathMatch: 'full'},
            {path: 'add-new-product', component: AddNewProductComponent},
            {path: 'receive-product-error', component: ReceiveProductErrorComponent},
            {path: 'send-product-to-agent', component: SendProductToAgentComponent},
            {path: 'statistic-product', component: StatisticProductComponent},
            {path: 'statistic-error-product', component: StatisticErrorProductComponent},
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class FactoryRoutingModule {
}
