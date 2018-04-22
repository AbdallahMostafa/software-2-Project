import {Component} from '@angular/core';
import{ServiceAdminLogin} from "../service/serviceAdminLogin.component";
import 'rxjs/add/operator/map';

@Component
({
selector:'home-page',
template:`
<a [routerLink]='["/SignUp"]'>SignUp</a>
<a [routerLink]='["/Login"]'>User Login</a>
`,
})
export class HomePageComponent{

}