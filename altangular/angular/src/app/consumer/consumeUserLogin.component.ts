import {Component, OnInit} from '@angular/core';
import {ServiceUserLogin} from '../service/serviceUserLogin.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import {MyAwesomeService} from '../test/test';
import { User } from '../interface/userInterFace';
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
    type: any;
    email : any;
    cart : any;
    _session : any;
    reciveData:any;
    ngOnInit() {
        this.user = {name: this.name, userName: this.userName, passWord : this.passWord, email : this.email, type: this.type, cart : this.cart }
    }
    constructor(private session :MyAwesomeService, private router: Router, private route: ActivatedRoute,private serviceObject:ServiceUserLogin)
    {
    }
    onSubmit()
    {
        this.serviceObject.get(this.user).subscribe(data =>{this.reciveData=data;});
        console.log(this.reciveData);
        if(this.reciveData.type =='0')
        {
            this.router.navigate(['/customerLogin', {  }], { relativeTo: this.route});

        }
        else if(this.reciveData.type =='1')
        {
            this.router.navigate(['/customerLoging', {  }], { relativeTo: this.route});

        }
        else{
            console.log("Error in logining in!!");
        }
        //this.router.navigate(['/SuggestStore', {  }], { relativeTo: this.route});
    }
}