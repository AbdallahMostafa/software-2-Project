import {Component, OnInit} from '@angular/core';
import {ServiceShowStoresOfSystem} from '../service/serviceShowStoresOfSystem.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router';
import {stores} from '../interface/store';

@Component
({
selector:'show-store',
template:`
<table border="1px">
    <tr>
        <td>Product Name</td>
        <td>Product Price</td>
        <td>Product views</td>
    </tr>
    <tr *ngFor="let data of reciveData; let i = index">
        <td>{{data.productName}}</td>
        <td>{{data.price}}</td>
    </tr>
    <button (click)="show_stores()">click</button>

</table>
`,
providers:[ServiceShowStoresOfSystem]
})
export class ConsumeShowProductOfStore implements OnInit
{
    private storeName : any;
    ngOnInit(){
        
    }
    reciveData:any;
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceShowStoresOfSystem)
    {
        this.storeName = this.route.snapshot.paramMap.get("storeName");
    }
    show_stores()
    {
        this.serviceObject.get_porducts(this.storeName).subscribe(data =>{this.reciveData=data;});
        //this.router.navigate(['/showProductOfStore', {  }], { relativeTo: this.route})
    }
}