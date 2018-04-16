import {Component, OnInit} from '@angular/core';
import {ServiceSuggestStores} from '../service/serviceSuggestStores.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router'
import { SuggestStores } from '../interface/suggestStore';

@Component
({
selector:'suggest-store',
template:`
<form (ngSubmit) = "onSubmit()">
    <p>Store Name: <input [(ngModel)]="suggestStores.storeName" [ngModelOptions]="{standalone: true}" type="text"></p>
    <p>Store Location: <input [(ngModel)]="suggestStores.storeLocation" [ngModelOptions]="{standalone: true}" type="text"></p>
    <select [(ngModel)]="suggestStores.type" [ngModelOptions]="{standalone: true}" >
        <option value="0">Online</option>
        <option value="1">Offline</option>
    </select>
    <p><input type="submit" value="Submit" /></p>
</form>
`,
providers:[ServiceSuggestStores]
})
export class ConsumeSuggestStores implements OnInit
{
    reciveData:any;
    sendData: any;
    suggestStores : SuggestStores ={storeName : '', storeLocation: '', type : ''}
    ngOnInit(){

    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceSuggestStores, private service : ServiceSuggestStores)
    {
        
    }
    /*show_suggested_stores()
    {
        this.serviceObject.get().subscribe(data =>{this.reciveData=data;});
        console.log(this.reciveData);
    }*/
    onSubmit()
    {
        
        this.service.send(this.suggestStores).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AcceptStore', {  }], { relativeTo: this.route})
    }
}