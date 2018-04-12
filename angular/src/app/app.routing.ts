import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {ConsumeAcceptStores} from './consumer/consumeAcceptStore.component';
import { ConsumeAdminLogin } from './consumer/consumeAdminLogin.component';
import {HomePageComponent} from './consumer/homePage.component';
import {ConsumeUserSignUp} from './consumer/consumeUserSignUp.component';
import {ConsumeUserLogin} from './consumer/consumeUserLogin.component';
import {ConsumeSuggestStores} from './consumer/consumeSuggestStores.component';
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

]

export const routers : ModuleWithProviders = RouterModule.forRoot(app_routs);
