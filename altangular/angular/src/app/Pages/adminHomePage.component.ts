import {Component} from '@angular/core';
import{ServiceAdminLogin} from "../service/serviceAdminLogin.component";
import 'rxjs/add/operator/map';

@Component
({
selector:'admin-home-page',
template:`
<a [routerLink]='["/AcceptStore"]'>AcceptStore</a>
<a [routerLink]='["/AddBrandToSystem"]'>Add Brand To System</a>
<a [routerLink]='["/AddProductToSystem"]'>Add Product To System</a>
`,
})
export class AdminHomePageComponent{

}