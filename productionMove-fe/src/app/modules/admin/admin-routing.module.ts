import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LayoutComponent} from "./layout/layout.component";
import {ProductLinesComponent} from "./pages/product-lines/product-lines.component";
import {ProductsComponent} from "./pages/products/products.component";
import {ProductStatisticsComponent} from "./pages/product-statistics/product-statistics.component";
import {ManageUserComponent} from "./pages/manage-user/manage-user.component";
import {AddUserComponent} from "./pages/add-user/add-user.component";
import {ProductlineDetailComponent} from "./pages/productline-detail/productline-detail.component";
import {NewProductlineComponent} from "./pages/new-productline/new-productline.component";

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            {path: '', redirectTo: 'product-lines', pathMatch: 'full'},
            {path: 'product-lines', component: ProductLinesComponent},
            {path: 'product-lines/:id', component: ProductlineDetailComponent},
            {path: 'add-product-line', component: NewProductlineComponent},
            {path: 'products', component: ProductsComponent},
            {path: 'product-statistics', component: ProductStatisticsComponent},
            {path: 'manage-user', component: ManageUserComponent},
            {path: 'add-user', component: AddUserComponent},
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AdminRoutingModule {
}
