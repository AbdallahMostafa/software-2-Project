import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';


import {HomePageComponent} from './Pages/homePage.component';
import {StoreOwnerHomePageComponent} from './Pages/storeOwnerHomePage.component';
import {AdminHomePageComponent} from './Pages/adminHomePage.component';

import {ConsumeUserSignUp} from './consumer/consumeUserSignUp.component';
import {ConsumeUserLogin} from './consumer/consumeUserLogin.component';
import {ConsumeSuggestStores} from './consumer/consumeSuggestStores.component';
import {ConsumeShowStoresOfSystem} from './consumer/consumeShowStoresOfSystem.component';
import {ConsumeShowProductOfStore} from './consumer/consumeShowProductOfStore.component';
import {ConsumeAddProductToSystem} from './consumer/ConsumeAddProductToSystem.component';
import {ConsumeAcceptStores} from './consumer/consumeAcceptStore.component';
import { ConsumeAdminLogin } from './consumer/consumeAdminLogin.component';

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
]

export const routers : ModuleWithProviders = RouterModule.forRoot(app_routs);
