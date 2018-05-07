import {Component,OnInit} from '@angular/core';
import {BrandService} from '../service/brandService.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import { Http ,HttpModule} from '@angular/http';
import {Brand} from '../interface/brand';
import { Product } from '../interface/product';
@Component
({
selector:'add-brand',
template:`
<div class="container">
    <div class="form-group">    
        <form (ngSubmit) = "onSubmit()">
            <p>Brand Name: <input class="form-control" [(ngModel)]="brand.brandName" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p><input class="form-control" type="submit" value="Submit"/></p>
        </form>
    </div>
</div>
`,
providers:[BrandService]
})
export class ConsumeBrandService implements OnInit, Brand
{
    brandName : any;
    product : Product;
    brandId : any;
    brand : Brand;
    ngOnInit() {
    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:BrandService)
    {
        this.brand = {brandName : this.brandName, product : this.product, brandId : this.brandId};
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