import {Component} from '@angular/core';
import {ServiceUserLogin} from '../service/serviceUserLogin.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'

@Component
({
selector:'user-sign-in',
template:`

<input type='text' #name>
<input type='text' #pass>
<button (click)="click_me(name.value, pass.value)">click</button>
`,
providers:[ServiceUserLogin]
})
export class ConsumeUserLogin
{
    username: any;
    password: any;
    reciveData:any;
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceUserLogin)
    {
        this.username = "";
        this.password = "";
    }
    click_me(username: any, password: any)
    {
        this.username=username;
        this.password = password;
        this.serviceObject.get(this.username,this.password).subscribe(data =>{this.reciveData=data;});
        this.router.navigate(['/SuggestStore', {  }], { relativeTo: this.route});

    }
}