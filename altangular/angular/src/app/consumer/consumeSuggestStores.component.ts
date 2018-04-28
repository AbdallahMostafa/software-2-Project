import {Component, OnInit} from '@angular/core';
import {ServiceSuggestStores} from '../service/serviceSuggestStores.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router'
import { SuggestStores } from '../interface/suggestStore';
import {User} from '../interface/userInterFace';
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {LocalStorage, SessionStorage} from 'ngx-webstorage';
@Component
({
selector:'suggest-store',
template:`
<div class ="container">
    <div class="form-group">
        <form (ngSubmit) = "onSubmit()">
            <p>Store Name: <input class="form-control" [(ngModel)]="suggestedStores.storeName" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Store Location: <input class="form-control" [(ngModel)]="suggestedStores.storeLocation" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p> Select Store Type:
                <select class="form-control" [(ngModel)]="suggestedStores.type" [ngModelOptions]="{standalone: true}" >
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
export class ConsumeSuggestStores implements OnInit, SuggestStores,User
{
    user : User;
    userName: any;
    passWord: any;
    name: any;
    email : any;
    cart : any;
    
    suggestedStores : SuggestStores;
    storeName: any;
    storeLocation: any;
    type : any;

    reciveData:any;
    sendData: any;
    ngOnInit(){
        this.user = {name: this.name, userName: this.userName, passWord : this.passWord, email : this.email, cart : this.cart }
        this.suggestedStores = {storeLocation : this.storeLocation, storeName : this.storeName, type : this.type};
    }
    constructor(private storage:LocalStorageService,private router: Router, private route: ActivatedRoute,private serviceObject:ServiceSuggestStores, private service : ServiceSuggestStores)
    {
        
    }
    onSubmit()
    {
        this.user = this.storage.retrieve('reciveData');
        console.log(this.user);
        this.service.send(this.suggestedStores, this.user).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AcceptStore', {  }], { relativeTo: this.route})
    }
}