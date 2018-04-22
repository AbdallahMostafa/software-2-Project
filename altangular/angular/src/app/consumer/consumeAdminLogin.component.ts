import {Component} from '@angular/core';
import {ServiceAdminLogin} from '../service/serviceAdminLogin.component';
import { ActivatedRoute, Router } from '@angular/router'

import 'rxjs/add/operator/map';

@Component
({
selector:'signin',
template:`
<div class="container">
    <div class="form-group">    
        <p> User Name : <input class="form-control" type='text' #name> </p> 
        <p> Password : <input class="form-control" type='text' #pass> </p>
        <button class="form-control" (click)="click_me(name.value, pass.value)">Login</button>
    </div>
</div>
`,
providers:[ServiceAdminLogin]
})
export class ConsumeAdminLogin
{
    username: any;
    password: any;
    reciveData:any;
    constructor(private serviceObject:ServiceAdminLogin, private router: Router, private route: ActivatedRoute)
    {
        this.username = "";
        this.password = "";
    }
    click_me(username: any, password: any)
    {
        this.username=username;
        this.password = password;
        this.serviceObject.get(this.username,this.password).subscribe(data =>{this.reciveData=data;});
        console.log(this.reciveData);
        this.router.navigate(['/LoggedIn', {  }], { relativeTo: this.route});
    }
}