import {Component,OnInit} from '@angular/core';
import {ServiceAddBrandToSystem} from '../service/ServiceAddBrandToSystem.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import {MyAwesomeService} from '../test/test';
import { Http ,HttpModule} from '@angular/http';
import {Brand} from '../interface/brand';
@Component
({
selector:'add-brand',
template:`
<form (ngSubmit) = "onSubmit()">
    <p>Brand Name: <input [(ngModel)]="product.productName" [ngModelOptions]="{standalone: true}" type="text"></p>
    <p><input type="submit" value="Submit"/></p>
</form>
`,
providers:[ServiceAddBrandToSystem]
})
export class ConsumeAddBrandToSystem implements OnInit
{
    
    brand : Brand = {brandName : ''}
    recivedData: any;
    ngOnInit() {
    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceAddBrandToSystem)
    {
        
    }
    onSubmit()
    {
        this.serviceObject.add_brand(this.brand).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AddProductToSystem', {  }], { relativeTo: this.route});
    }
}