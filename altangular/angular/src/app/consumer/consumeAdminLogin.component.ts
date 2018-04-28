import {Component, OnInit} from '@angular/core';
import {ServiceAdminLogin} from '../service/serviceAdminLogin.component';
import { ActivatedRoute, Router } from '@angular/router'
import 'rxjs/add/operator/map';
import {Admin} from '../interface/admin';
@Component
({
selector:'signin',
template:`
<div class="container">
    <div class="form-group">    
        <form (ngSubmit) = "onSubmit()">
            <p> User Name : <input class="form-control" [(ngModel)]="admin.userName" [ngModelOptions]="{standalone: true}" type='text' > </p> 
            <p> Password : <input class="form-control" [(ngModel)]="admin.passWord" [ngModelOptions]="{standalone: true}" type='password' > </p>
            <button class="form-control">Login</button>
        </form>
    </div>
</div>
`,
providers:[ServiceAdminLogin]
})
export class ConsumeAdminLogin implements OnInit, Admin
{

    userName: any;
    passWord: any;
    name: any;
    email : any;
    reciveData:any;
    admin : Admin;
    ngOnInit() {
        this.admin = {name: this.name, userName: this.userName, passWord : this.passWord, email : this.email}
    }
    constructor(private serviceObject:ServiceAdminLogin, private router: Router, private route: ActivatedRoute)
    {

    }
    onSubmit()
    {
        this.serviceObject.get(this.admin).subscribe(data =>{this.reciveData=data;});
        if(this.reciveData != null)
        {
        this.router.navigate(['/LoggedIn', {  }], { relativeTo: this.route});
        }
        else
        {
            console.log("Error logining in !!!");
        }
    }
}