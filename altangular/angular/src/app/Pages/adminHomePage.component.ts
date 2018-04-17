import {Component} from '@angular/core';
import{ServiceAdminLogin} from "../service/serviceAdminLogin.component";
import 'rxjs/add/operator/map';

@Component
({
selector:'admin-home-page',
template:`
<a [routerLink]='["/AcceptStore"]'>AcceptStore</a>
<a [routerLink]='["/AddBrandToSystem"]'>User Login</a>
<a [routerLink]='[AddProductToSystem]'>AddProductToSystem</a>
`,

})
export class AdminHomePageComponent{

}