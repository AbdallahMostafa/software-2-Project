import {Component,OnInit} from '@angular/core';
import {BrandService} from '../service/brandService.component';
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
providers:[BrandService]
})
export class ConsumeBrandService implements OnInit
{
    
    brand : Brand = {brandName : ''}
    ngOnInit() {
    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:BrandService)
    {
        
    }
    onSubmit()
    {
        this.serviceObject.add_brand(this.brand).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AddBrandToSystem', {  }], { relativeTo: this.route});
    }
}