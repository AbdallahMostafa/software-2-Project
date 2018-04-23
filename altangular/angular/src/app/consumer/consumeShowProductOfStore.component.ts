import {Component, OnInit} from '@angular/core';
import {ServiceShowStoresOfSystem} from '../service/serviceShowStoresOfSystem.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router';
import {Stores} from '../interface/store';

@Component
({
selector:'show-store',
template:`
<div class="container">
    <table class="table" border="1px">
        <tr>
            <th scope="col">Product Name</th>
            <th scope="col">Product Price</th>
            <th scope="col">Product views</th>
        </tr>
        <tr *ngFor="let data of reciveData; let i = index">
            <td scope="row">{{data.productName}}</td>
            <td scope="row">{{data.price}}</td>
        </tr>
    </table>
    <button class="form-control" (click)="show_stores()">Show Product Of Store</button>

</div>
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