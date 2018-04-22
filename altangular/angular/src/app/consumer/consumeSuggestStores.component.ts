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
<div class ="container">
    <div class="form-group">
        <form (ngSubmit) = "onSubmit()">
            <p>Store Name: <input class="form-control" [(ngModel)]="suggestStores.storeName" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Store Location: <input class="form-control" [(ngModel)]="suggestStores.storeLocation" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p> Select Store Type:
                <select class="form-control" [(ngModel)]="suggestStores.type" [ngModelOptions]="{standalone: true}" >
                    <option value="0">Online</option>
                    <option value="1">Offline</option>
                </select>
            </p>
            <p><input class="form-control" type="submit" value="Submit" /></p>
        </form>
    </div>
</div>
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
    onSubmit()
    {
        
        this.service.send(this.suggestStores).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AcceptStore', {  }], { relativeTo: this.route})
    }
}