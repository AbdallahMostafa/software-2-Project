import {Component,OnInit} from '@angular/core';
import {ServiceUserSignUp} from '../service/serviceUserSignUp.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import { User } from '../interface/userInterFace';
import {MyAwesomeService} from '../test/test';
import { Http ,HttpModule} from '@angular/http';

@Component
({
selector:'sign-up',
template:`
<form (ngSubmit) = "onSubmit()">
    <p>Name: <input [(ngModel)]="normalUser.name" [ngModelOptions]="{standalone: true}" type="text"></p>
    <p>UserName: <input [(ngModel)]="normalUser.userName" [ngModelOptions]="{standalone: true}" type="text"></p>
    <p>Password: <input [(ngModel)]="normalUser.passWord" [ngModelOptions]="{standalone: true}" type="password" ></p>
    <p>Email: <input [(ngModel)]="normalUser.email" [ngModelOptions]="{standalone: true}" type="text"></p>
    <p>Select Type :
        <select [(ngModel)]="normalUser.type" [ngModelOptions]="{standalone: true}" >
            <option value="0">Normal User</option>
            <option value="1">Store Owner</option>
        </select>
    </p>
    <p><input type="submit" value="Sign Up" /></p>
</form>
`,
providers:[ServiceUserSignUp]
})
export class ConsumeUserSignUp implements OnInit
{
    /*name: any;
    username: any;
    password: any;
    emial: any;
    type: any;*/
    normalUser : User ={ name : '' ,userName:'' ,passWord:'' ,email:'' ,type:''};
    dummy: any;
    ngOnInit() {
    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceUserSignUp)
    {
        
    }
    onSubmit()
    {
        this.serviceObject.get(this.normalUser).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AcceptStore', {  }], { relativeTo: this.route});
    }
}