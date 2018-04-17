import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
import {routers} from './app.routing';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AppComponent }  from './app.component';

import{ServiceAdminLogin} from "./service/serviceAdminLogin.component";
import{ServiceAcceptStores} from "./service/serviceAcceptStores.component";
import {ServiceUserSignUp} from './service/serviceUserSignUp.component';
import {ServiceSuggestStores} from './service/serviceSuggestStores.component';
import {ServiceShowStoresOfSystem} from './service/serviceShowStoresOfSystem.component';
import {ServiceAddProductToSystem} from './service/serviceAddProductToSystem.component';
import {HomePageComponent} from './consumer/homePage.component';
import {StoreOwnerHomePageComponent} from './consumer/storeOwnerHomePage.component';

import {ConsumeUserSignUp} from './consumer/consumeUserSignUp.component';
import {ConsumeUserLogin} from './consumer/consumeUserLogin.component';
import {ConsumeSuggestStores} from './consumer/consumeSuggestStores.component';
import{ConsumeAdminLogin} from './consumer/consumeAdminLogin.component';
import {ConsumeAcceptStores} from './consumer/consumeAcceptStore.component';
import {ConsumeShowStoresOfSystem} from './consumer/consumeShowStoresOfSystem.component';
import {ConsumeShowProductOfStore} from './consumer/consumeShowProductOfStore.component';
import {ConsumeAddProductToSystem} from './consumer/ConsumeAddProductToSystem.component';
import { SESSION_STORAGE } from 'angular-webstorage-service';
import { StorageServiceModule } from 'angular-webstorage-service';
import { MY_AWESOME_SERVICE_STORAGE, MyAwesomeService } from './test/test';


@NgModule({
  imports:      [ 
    BrowserModule,
     HttpModule, 
     routers,
     HttpClientModule,
     FormsModule,
     StorageServiceModule,
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
     ConsumeShowStoresOfSystem,
     ConsumeShowProductOfStore,
     ConsumeAddProductToSystem,
    ],
  providers: [
    {provide : MY_AWESOME_SERVICE_STORAGE, useExisting: SESSION_STORAGE},
    MyAwesomeService,
    ServiceAdminLogin,
    ServiceAcceptStores, 
    ServiceUserSignUp, 
    ServiceSuggestStores,
    ServiceShowStoresOfSystem,
    ServiceAddProductToSystem,
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
