import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpModule} from '@angular/http';
import {routers} from './app.routing';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {Ng2Webstorage} from 'ngx-webstorage';
import { AppComponent }  from './app.component';

import{ServiceAdminLogin} from "./service/serviceAdminLogin.component";
import{ServiceAcceptStores} from "./service/serviceAcceptStores.component";
import {ServiceUserSignUp} from './service/serviceUserSignUp.component';
import {ServiceSuggestStores} from './service/serviceSuggestStores.component';
import {ServiceShowStoresOfSystem} from './service/serviceShowStoresOfSystem.component';
import {ServiceAddProductToSystem} from './service/serviceAddProductToSystem.component';
import {BrandService} from './service/brandService.component';
import {ServiceAddProductToStore} from './service/serviceAddProductToStore.component';

import {HomePageComponent} from './Pages/homePage.component';
import {StoreOwnerHomePageComponent} from './Pages/storeOwnerHomePage.component';
import {AdminHomePageComponent} from './Pages/adminHomePage.component';
import {CustomerHomePageComponent} from './Pages/customerHomePage.component';

import {ConsumeUserSignUp} from './consumer/consumeUserSignUp.component';
import {ConsumeUserLogin} from './consumer/consumeUserLogin.component';
import {ConsumeSuggestStores} from './consumer/consumeSuggestStores.component';
import {ConsumeAdminLogin} from './consumer/consumeAdminLogin.component';
import {ConsumeAcceptStores} from './consumer/consumeAcceptStore.component';
import {ConsumeShowStoresOfSystem} from './consumer/consumeShowStoresOfSystem.component';
import {ConsumeShowProductOfStore} from './consumer/consumeShowProductOfStore.component';
import {ConsumeAddProductToSystem} from './consumer/consumeAddProductToSystem.component';
import {ConsumeBrandService} from './consumer/consumeBrandService.component';
import {ConsumeAddProductToStore} from './consumer/consumeAddProductToStore.component';
import {ConsumeBuyProdcutFromStore} from './consumer/consumeBuyProductFromStore.component';

import { SESSION_STORAGE } from 'angular-webstorage-service';
import { StorageServiceModule } from 'angular-webstorage-service';


@NgModule({
  imports:      [ 
    BrowserModule,
     HttpModule, 
     routers,
     HttpClientModule,
     FormsModule,
     StorageServiceModule,
     Ng2Webstorage,
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
     AdminHomePageComponent,
     ConsumeShowStoresOfSystem,
     ConsumeShowProductOfStore,
     ConsumeAddProductToSystem,
     AdminHomePageComponent,
     ConsumeBrandService,
     CustomerHomePageComponent,
     ConsumeAddProductToStore,
     ConsumeBuyProdcutFromStore,
    ],
  providers: [
    ServiceAdminLogin,
    ServiceAcceptStores, 
    ServiceUserSignUp, 
    ServiceSuggestStores,
    ServiceShowStoresOfSystem,
    ServiceAddProductToSystem,
    BrandService,
    ServiceAddProductToStore,
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
