import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import { User } from '../interface/userInterFace';
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {LocalStorage, SessionStorage} from 'ngx-webstorage';
 
@Component
({
selector:'customer-home-page',
template:`
<a [routerLink]='["/SuggestStore"]'>Suggest Stores</a>

`,

})
export class CustomerHomePageComponent implements OnInit{
    public user : User;
    constructor(private storage:LocalStorageService)
    {

    }
    ngOnInit()
    {
        this.user = this.storage.retrieve('reciveData');
        console.log(this.user);
    }
    

}