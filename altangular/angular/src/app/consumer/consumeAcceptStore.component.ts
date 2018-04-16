import {Component} from '@angular/core';
import {ServiceAcceptStores} from '../service/serviceAcceptStores.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router';
import {MyAwesomeService} from '../test/test';

@Component
({
selector:'accept-store',
template:`
<table border="1px">
    <tr>
        <td>Store Name</td>
        <td>Store Location</td>
        <td>Store Type</td>
        <td>Store Owner</td>
    </tr>
    <tr *ngFor="let data of reciveData">
        <td><a (click)="send_data(data.storeName)">{{data.storeName}}</a></td>
        <td>{{data.storeLocation}}</td>
        <td>{{data.type}}</td>
        <td>{{data.storeOwner.name}}</td>
    </tr>
</table>
<button (click)="show_suggested_stores()">click</button>

`,
providers:[ServiceAcceptStores,MyAwesomeService]
})
export class ConsumeAcceptStores
{
    reciveData:any;
    sendData: any;
    storeName:any;
    storeLocation:any;
    type:any;
    storeOwner:any;
    constructor(private hhh: MyAwesomeService,private router: Router, private route: ActivatedRoute,private serviceObject:ServiceAcceptStores, private service : ServiceAcceptStores)
    {

    }
    show_suggested_stores()
    {
        this.serviceObject.get().subscribe(data =>{this.reciveData=data;});
        console.log(this.reciveData);

    }
    send_data(storeName:any)
    {
        this.storeName = storeName;
        this.service.send(this.storeName).subscribe(dataOfStore =>{this.sendData=dataOfStore;});
        
        this.router.navigate(['/AcceptStore', {  }], { relativeTo: this.route})
    }
}