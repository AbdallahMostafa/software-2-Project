import {Component} from '@angular/core';
import {ServiceAdminLogin} from '../service/serviceAdminLogin.component';
import 'rxjs/add/operator/map';

@Component
({
selector:'signin',
template:`

<input type='text' #name>
<input type='text' #pass>
<button (click)="click_me(name.value, pass.value)">click</button>
`,
providers:[ServiceAdminLogin]
})
export class ConsumeAdminLogin
{
    username: any;
    password: any;
    reciveData:any;
    constructor(private serviceObject:ServiceAdminLogin)
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

    }
}