import {Component,OnInit} from '@angular/core';
import {ServiceUserSignUp} from '../service/serviceUserSignUp.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import { User } from '../interface/userInterFace';
import { Http ,HttpModule} from '@angular/http';

@Component
({
selector:'sign-up',
template:`
<div class ="container">
    <div class="form-group">    
        <form (ngSubmit) = "onSubmit()">
                <p>Name: <input class="form-control" [(ngModel)]="normalUser.name" [ngModelOptions]="{standalone: true}" type="text"></p>
                <p>UserName: <input class="form-control" [(ngModel)]="normalUser.userName" [ngModelOptions]="{standalone: true}" type="text"></p>
                <p>Password: <input class="form-control" [(ngModel)]="normalUser.passWord" [ngModelOptions]="{standalone: true}" type="password" ></p>
                <p>Email: <input class="form-control" [(ngModel)]="normalUser.email" [ngModelOptions]="{standalone: true}" type="text"></p>
                <p><input class="form-control" type="submit" value="Sign Up" /></p>
        </form>
    </div>
</div>
`,
providers:[ServiceUserSignUp]
})
export class ConsumeUserSignUp implements OnInit, User
{

    normalUser : User;
    userName: any;
    passWord: any;
    name: any;
    email : any;
    cart : any;
    recived :any;
    collaborator : any;
    ngOnInit() {
        this.normalUser = {name: this.name, userName: this.userName, passWord : this.passWord, email : this.email, cart : this.cart, collaborator : this.collaborator }

    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceUserSignUp)
    {
        
    }
    onSubmit()
    {
        this.serviceObject.get(this.normalUser).subscribe(
            value => {
              console.log('[POST] create Customer successfully',this.recived =  value);
            });
        console.log(this.recived);
        if( this.recived ==true){
        this.router.navigate(['/Login', {  }], { relativeTo: this.route});
        }
        
    }
}