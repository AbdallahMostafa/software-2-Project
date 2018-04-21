import {Component} from '@angular/core';
import {ServiceUserLogin} from '../service/serviceUserLogin.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import {MyAwesomeService} from '../test/test';

@Component
({
selector:'user-sign-in',
template:`

<p> User Name : <input type='text' #name> </p> 
<p> Password : <input type='text' #pass> </p>
<button (click)="click_me(name.value, pass.value)">Login</button>
`,
providers:[ServiceUserLogin]
})
export class ConsumeUserLogin
{
    username: any;
    password: any;
    _session : any;
    reciveData:any;
    constructor(private session :MyAwesomeService, private router: Router, private route: ActivatedRoute,private serviceObject:ServiceUserLogin)
    {
        this.username = "";
        this.password = "";
    }
    click_me(username: any, password: any)
    {
        this.username=username;
        this.password = password;
        this.serviceObject.get(this.username,this.password ).subscribe(data =>{this.reciveData=data;});
        console.log(this.reciveData);
        this.router.navigate(['/SuggestStore', {  }], { relativeTo: this.route});
    }
}