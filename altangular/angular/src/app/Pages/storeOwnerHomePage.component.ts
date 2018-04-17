import {Component} from '@angular/core';
import 'rxjs/add/operator/map';

@Component
({
selector:'store-owner-home-page',
template:`
<a [routerLink]='["/SuggestStore"]'>Suggest Stores</a>
`,

})
export class StoreOwnerHomePageComponent{

}