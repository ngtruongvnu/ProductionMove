import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AuthGuard} from "./core/guard/auth.guard";
import {LoginComponent} from "./shared/components/login/login.component";

const routes: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'admin',
        loadChildren: () => import('./modules/admin/admin.module').then(m => m.AdminModule),
        canActivate: [AuthGuard]
    },
    {
        path: 'agent',
        loadChildren: () => import('./modules/agent/agent.module').then(m => m.AgentModule),
        canActivate: [AuthGuard]
    },
    {
        path: 'factory',
        loadChildren: () => import('./modules/factory/factory.module').then(m => m.FactoryModule),
        canActivate: [AuthGuard]
    },
    {
        path: 'service-center',
        loadChildren: () => import('./modules/service-center/service-center.module').then(m => m.ServiceCenterModule),
        canActivate: [AuthGuard]
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
