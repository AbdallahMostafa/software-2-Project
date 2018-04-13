import {Component} from '@angular/core';
import {ServiceShowStoresOfSystem} from '../service/serviceShowStoresOfSystem.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router'
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
        <td>{{data.storeName}}</td>
        <td>{{data.storeLocation}}</td>
    </tr>
    <button (click)="show_stores()">click</button>

</table>
`,
providers:[ServiceShowStoresOfSystem]
})
export class ConsumeShowStoresOfSystem
{
    reciveData:any;
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceShowStoresOfSystem)
    {

    }
    show_stores()
    {
        this.serviceObject.get().subscribe(data =>{this.reciveData=data;});
        console.log(this.reciveData);
    }
}