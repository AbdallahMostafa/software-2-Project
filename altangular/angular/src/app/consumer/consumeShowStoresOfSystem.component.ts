import {Component} from '@angular/core';
import {ServiceShowStoresOfSystem} from '../service/serviceShowStoresOfSystem.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router';
import {stores} from '../interface/store';
import {MyAwesomeService} from '../test/test';

@Component
({
selector:'show-store',
template:`
<table border="1px">
    <tr>
        <td>Store Name</td>
        <td>Store Location</td>
    </tr>
    <tr *ngFor="let data of reciveData">
        <td><a (click) = "navgate(data.storeName)">{{data.storeName}}</a></td>
        <td>{{data.storeLocation}}</td>
    </tr>
    <button (click)="show_stores()">click</button>

</table>
`,
providers:[ServiceShowStoresOfSystem]
})
export class ConsumeShowStoresOfSystem
{
    store : stores ={ storeName : '' ,storeLocation : '', type : '', storeOwner: ''};

    reciveData:any;
    Dara : any;
    constructor(private session :MyAwesomeService,private router: Router, private route: ActivatedRoute,private serviceObject:ServiceShowStoresOfSystem)
    {

    }
    show_stores()
    {
        this.serviceObject.get().subscribe(data =>{this.reciveData=data;});
        //this.router.navigate(['/showProductOfStore', { }], { relativeTo: this.route})

        console.log(this.reciveData);
    }
    navgate(storeName: any){
        this.serviceObject.setStoreName(storeName);
        //this.session.doSomethingAwesome(storeName);
        //this.serviceObject.get_porducts(storeName).subscribe(data => {this.Dara = data;});
        this.router.navigate(['/showProductOfStore', {storeName:storeName}], { relativeTo: this.route})

    }
}