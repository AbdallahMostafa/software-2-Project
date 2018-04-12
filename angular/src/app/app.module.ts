import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
import{ServiceAdminLogin} from "./service/serviceAdminLogin.component";
import{ServiceAcceptStores} from "./service/serviceAcceptStores.component";
import {ServiceUserSignUp} from './service/serviceUserSignUp.component';
import {ServiceSuggestStores} from './service/serviceSuggestStores.component';
import {routers} from './app.routing';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppComponent }  from './app.component';
import{ConsumeAdminLogin} from './consumer/consumeAdminLogin.component';
import {ConsumeAcceptStores} from './consumer/consumeAcceptStore.component';
import {HomePageComponent} from './consumer/homePage.component';
import {ConsumeUserSignUp} from './consumer/consumeUserSignUp.component';
import {ConsumeUserLogin} from './consumer/consumeUserLogin.component';
import {ConsumeSuggestStores} from './consumer/consumeSuggestStores.component';
import {StoreOwnerHomePageComponent} from './consumer/storeOwnerHomePage.component';
@NgModule({
  imports:      [ 
    BrowserModule,
     HttpModule, 
     routers,
     HttpClientModule,
     FormsModule,
     ],

  declarations: [
     AppComponent, 
     ConsumeAdminLogin, 
     ConsumeAcceptStores, 
     HomePageComponent, 
     ConsumeUserSignUp,
     ConsumeUserLogin, 
     ConsumeSuggestStores,
     StoreOwnerHomePageComponent,
    ],
  providers: [ServiceAdminLogin, ServiceAcceptStores, ServiceUserSignUp, ServiceSuggestStores],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
