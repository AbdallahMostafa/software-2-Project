import {Component, OnInit} from '@angular/core';
import {ServiceUserLogin} from '../service/serviceUserLogin.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import { User } from '../interface/userInterFace';
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {LocalStorage, SessionStorage} from 'ngx-webstorage';
 

@Component
({
selector:'user-sign-in',
template:`
<div class = "container">
    <div class="form-group">    
        <form (ngSubmit) = "onSubmit()">
            <p> User Name : <input class="form-control" [(ngModel)]="user.userName" [ngModelOptions]="{standalone: true}" type='text' > </p> 
            <p> Password : <input class="form-control" [(ngModel)]="user.passWord" [ngModelOptions]="{standalone: true}" type='password' > </p>
            <button class="form-control">Login</button>
        </form>
    </div>
</div>
`,
providers:[ServiceUserLogin]
})
export class ConsumeUserLogin implements OnInit, User
{
    user : User;
    userName: any;
    passWord: any;
    name: any;
    email : any;
    cart : any;
    collaborator : any;

    @LocalStorage()
    public reciveData:any;
    ngOnInit() {
        this.user = {name: this.name, userName: this.userName, passWord : this.passWord, email : this.email, cart : this.cart, collaborator : this.collaborator}
    }
    constructor(private storage:LocalStorageService, private router: Router, private route: ActivatedRoute,private serviceObject:ServiceUserLogin)
    {
    }
    onSubmit()
    {
        this.serviceObject.get(this.user).subscribe(
            data =>{
                this.reciveData=data;
                console.log(data);
            });
     //console.log(this.reciveData);
        this.storage.store('reciveData', this.reciveData);

        if(this.reciveData.userName==this.user.userName && this.reciveData.passWord==this.user.passWord)
        {
            console.log("heey");
            this.router.navigate(['/showStoresOfSystem', {  }], { relativeTo: this.route});
        }
        //this.router.navigate(['/SuggestStore', {  }], { relativeTo: this.route});
    }
}