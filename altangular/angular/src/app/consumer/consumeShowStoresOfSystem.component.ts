import {Component} from '@angular/core';
import {ServiceShowStoresOfSystem} from '../service/serviceShowStoresOfSystem.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router';
import {Stores} from '../interface/store';
import {MyAwesomeService} from '../test/test';

@Component
({
selector:'show-store',
template:`
<div class="container">
    <table class="table" border="1px">
        <tr>
            <th scope="col">Store Name</th>
            <th scope="col">Store Location</th>
        </tr>
        <tr *ngFor="let data of reciveData">
            <td scope="row"><a (click) = "navgate(data.storeName)">{{data.storeName}}</a></td>
            <td scope="row">{{data.storeLocation}}</td>
        </tr>
    </table>
    <button class ="form-control" (click)="show_stores()">Show Stores</button>
</div>
`,
providers:[ServiceShowStoresOfSystem]
})
export class ConsumeShowStoresOfSystem
{
    store : Stores //={ storeName : '' ,storeLocation : '', type : '', storeOwner: ''};

    reciveData:any;
    Dara : any;
    constructor(private session :MyAwesomeService,private router: Router, private route: ActivatedRoute,private serviceObject:ServiceShowStoresOfSystem)
    {

    }
    show_stores()
    {
        this.serviceObject.get().subscribe(data =>{this.reciveData=data;});
        //this.router.navigate(['/showProductOfStore', { }], { relativeTo: this.route})
    }
    navgate(storeName: any){
        this.serviceObject.setStoreName(storeName);
        this.router.navigate(['/showProductOfStore', {storeName:storeName}], { relativeTo: this.route})
    }
}