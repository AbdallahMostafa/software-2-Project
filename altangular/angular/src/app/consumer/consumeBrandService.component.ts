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