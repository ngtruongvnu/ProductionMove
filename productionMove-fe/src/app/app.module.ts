import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NZ_I18N} from 'ng-zorro-antd/i18n';
import {en_US} from 'ng-zorro-antd/i18n';
import {registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {IconsProviderModule} from './icons-provider.module';
import {NzLayoutModule} from 'ng-zorro-antd/layout';
import {NzMenuModule} from 'ng-zorro-antd/menu';
import {NzButtonModule} from "ng-zorro-antd/button";
import {AuthGuard} from "./core/guard/auth.guard";
import {LoginComponent} from "./shared/components/login/login.component";
import {NzCardModule} from "ng-zorro-antd/card";
import {NzFormModule} from "ng-zorro-antd/form";
import {NzInputModule} from "ng-zorro-antd/input";
import {NzSpinModule} from "ng-zorro-antd/spin";
import {ToastrModule} from "ngx-toastr";

registerLocaleData(en);

@NgModule({
    declarations: [
        AppComponent,
        LoginComponent
    ],
    imports: [
        ToastrModule.forRoot({
            timeOut: 3000,
            extendedTimeOut: 1000,
            closeButton: true,
            progressBar: true,
            progressAnimation: 'decreasing',
            newestOnTop: true,
        }),
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        BrowserAnimationsModule,
        IconsProviderModule,
        NzLayoutModule,
        NzMenuModule,
        NzButtonModule,
        NzCardModule,
        ReactiveFormsModule,
        NzFormModule,
        NzInputModule,
        NzSpinModule
    ],
    providers: [
        {provide: NZ_I18N, useValue: en_US},
        AuthGuard
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
