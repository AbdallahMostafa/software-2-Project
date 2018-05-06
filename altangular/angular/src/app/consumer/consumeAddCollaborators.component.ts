import {Component,OnInit} from '@angular/core';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import { Http ,HttpModule} from '@angular/http';
import {User} from '../interface/userInterFace';
import { Product } from '../interface/product';
import { ServiceAddCollaborators } from '../service/serviceAddCollaboratorsToStore.component';
import { Cart } from '../interface/cart';

@Component
({
selector:'add-brand',
template:`
<div class="container">
    <div class="form-group">    
        <form (ngSubmit) = "onSubmit()">
            <p>Collaborator Name: <input class="form-control" [(ngModel)]="collaborator.value" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p><input class="form-control" type="submit" value="Submit"/></p>
        </form>
    </div>
</div>
`,
providers:[ServiceAddCollaborators]
})
export class ConsumeAddCollaborators implements OnInit, User
{
    name: any;
    userName: any;
    passWord: any;
    email: any;
    cart : Cart;
    collaborator: any;
    user : User;
    ngOnInit() {
    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceAddCollaborators)
    {
    }
    onSubmit()
    {
        this.serviceObject.add_collaborators(this.user,this.collaborator ).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AddBrandToSystem', {  }], { relativeTo: this.route});
    }
}