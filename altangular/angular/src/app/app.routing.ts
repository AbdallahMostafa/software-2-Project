import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';


import {HomePageComponent} from './Pages/homePage.component';
import {StoreOwnerHomePageComponent} from './Pages/storeOwnerHomePage.component';
import {AdminHomePageComponent} from './Pages/adminHomePage.component';
import {CustomerHomePageComponent} from './Pages/customerHomePage.component';
import {ConsumeUserSignUp} from './consumer/consumeUserSignUp.component';
import {ConsumeUserLogin} from './consumer/consumeUserLogin.component';
import {ConsumeSuggestStores} from './consumer/consumeSuggestStores.component';
import {ConsumeShowStoresOfSystem} from './consumer/consumeShowStoresOfSystem.component';
import {ConsumeShowProductOfStore} from './consumer/consumeShowProductOfStore.component';
import {ConsumeAddProductToSystem} from './consumer/consumeAddProductToSystem.component';
import {ConsumeAcceptStores} from './consumer/consumeAcceptStore.component';
import { ConsumeAdminLogin } from './consumer/consumeAdminLogin.component';
import {ConsumeBrandService} from './consumer/consumeBrandService.component';
import {ConsumeAddProductToStore} from './consumer/consumeAddProductToStore.component';


const app_routs: Routes = [
    {
        path: '',
        component: HomePageComponent
    },
    {
        path: 'AcceptStore',
        component: ConsumeAcceptStores
    },
    {
        path: 'AdminLogin',
        component: ConsumeAdminLogin
    },
    {
        path: 'SignUp',
        component: ConsumeUserSignUp
    },
    {
        path: 'Login',
        component: ConsumeUserLogin
    },
    {
        path: 'SuggestStore',
        component : ConsumeSuggestStores
    },
    {
        path: 'showStoresOfSystem',
        component: ConsumeShowStoresOfSystem
    },
    {
        path : 'showProductOfStore',
        component : ConsumeShowProductOfStore
    },
    {
        path : 'AddProductToSystem',
        component : ConsumeAddProductToSystem
    },
    {
        path : 'AddBrandToSystem',
        component : ConsumeBrandService
    },
    {
        path : 'LoggedIn',
        component : AdminHomePageComponent
    },
    {
        path : 'storeOwmerLogin',
        component : StoreOwnerHomePageComponent
    },
    {
        path : 'customerLogin',
        component : CustomerHomePageComponent
    },
    {
        path : 'AssignProductToStore',
        component : ConsumeAddProductToStore
    },  
]

export const routers : ModuleWithProviders = RouterModule.forRoot(app_routs);
