import {Component,OnInit} from '@angular/core';
import {ServiceAddProductToSystem} from '../service/serviceAddProductToSystem.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router'
import { Product } from '../interface/product';
import { Http ,HttpModule} from '@angular/http';
import {Brand} from '../interface/brand';
@Component
({
selector:'add-product',
template:`
<div class="container">
    <div class="form-group">
        <form (ngSubmit) = "onSubmit()">
            <p>Product Name: <input class="form-control" [(ngModel)]="product.productName" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Product Category: <input class="form-control" [(ngModel)]="product.productCategory" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Product Max Price: <input class="form-control" [(ngModel)]="product.productPriceMax" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Product Min Price: <input  class="form-control" [(ngModel)]="product.productPriceMin" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Product Type
                <select class="form-control" [(ngModel)]="product.productType" [ngModelOptions]="{standalone: true}" >
                    <option value="0">Online</option>
                    <option value="1">Offline</option>
                </select>
            </p>
            <p>Brand : 
                <select class="form-control" [(ngModel)]="brand.brandName" [ngModelOptions]="{standalone: true}" >
                    <option *ngFor="let data of recivedData" value ="{{data.brandId}}">{{data.brandName}}</option>
                </select>
            </p>
            <p><input class="form-control" type="submit" value="Submit"/></p>
        </form>
    </div>
</div>
`,
providers:[ServiceAddProductToSystem]
})
export class ConsumeAddProductToSystem implements OnInit, Brand, Product
{

    productName : any;
    productCategory : any;
    productType : any;
    brand : Brand;
    productPriceMax : any;
    productPriceMin : any;

    brandName : any;
    product : Product;
    brandId : any;

    recivedData: any;

    ngOnInit() {
        this.product = {productName : this.productName, productCategory : this.productCategory, productType : this.productType, brand : this.brand, productPriceMax : this.productPriceMax, productPriceMin : this.productPriceMin};
        this.brand = {brandName : this.brandName, product: this.product, brandId : this.brandId}
    }
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceAddProductToSystem)
    {
        this.get_brand();
    }
    get_brand()
    {
        this.serviceObject.get_brands().subscribe(
            value =>{
                this.recivedData = value.json(); 
            });
            console.log(this.recivedData);
    }
    onSubmit()
    {
        this.serviceObject.add_product(this.product).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        this.router.navigate(['/AddProductToSystem', {  }], { relativeTo: this.route});
    }
}