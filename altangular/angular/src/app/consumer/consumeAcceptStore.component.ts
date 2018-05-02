import {Component} from '@angular/core';
import {ServiceAcceptStores} from '../service/serviceAcceptStores.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router';

@Component
({
selector:'accept-store',
template:`
<div class="container">
    <table class="table" border="1px">
        <tr>
            <th scope="col">Store Name</th>
            <th scope="col">Store Location</th>
            <th scope="col">Store Type</th>
            <th scope="col">Store Owner</th>
        </tr>
        <tr *ngFor="let data of reciveData">
            <td scope="row"><a (click)="send_data(data.storeName)">{{data.storeName}}</a></td>
            <td scope="row">{{data.storeLocation}}</td>
            <td scope="row">{{data.type}}</td>
            <td scope="row">{{data.storeOwner.name}}</td>
        </tr>
    </table>
    <button class="form-control" (click)="show_suggested_stores()">Show Suggested Stores</button>
</div>

`,
providers:[ServiceAcceptStores]
})
export class ConsumeAcceptStores
{
    reciveData:any;
    sendData: any;
    storeName:any;
    storeLocation:any;
    type:any;
    storeOwner:any;
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceAcceptStores, private service : ServiceAcceptStores)
    {

    }
    show_suggested_stores()
    {
        this.serviceObject.get().subscribe(data =>{this.reciveData=data;});
    }
    send_data(storeName:any)
    {
        this.storeName = storeName;
        this.service.send(this.storeName).subscribe(dataOfStore =>{this.sendData=dataOfStore;});
        
        this.router.navigate(['/AcceptStore', {  }], { relativeTo: this.route})
    }
}