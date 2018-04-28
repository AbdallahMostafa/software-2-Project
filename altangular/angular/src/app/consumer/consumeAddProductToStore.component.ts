import {Component,OnInit} from '@angular/core';
import {ServiceAddProductToStore} from '../service/serviceAddProductToStore.component';
import 'rxjs/add/operator/map';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../interface/product';
import { ProductInstance } from '../interface/productInstance';
import {MyAwesomeService} from '../test/test';
import { Http ,HttpModule} from '@angular/http';
import {Brand} from '../interface/brand';
import {Stores} from '../interface/store';
import {Cart} from '../interface/cart';
import {User} from '../interface/userInterFace';
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {LocalStorage, SessionStorage} from 'ngx-webstorage';
import {ServiceShowStoresOfSystem} from '../service/serviceShowStoresOfSystem.component';
@Component
({
selector:'add-product',
template:`
<div class="container">
    <div class="form-group">
        <form (ngSubmit) = "onSubmit()">
            <table class="table" border="1px">
                <tr>
                    <th scope="col">Product Name</th>
                    <th scope="col">Product Category</th>
                    <th scope="col">Product Type</th>
                    <th scope="col">Brand</th>
                </tr>
                <tr *ngFor="let data of recivedData">
                    <td scope="row">{{data.productName}}</td>
                    <td scope="row">{{data.productCategory}}</td>
                    <td scope="row">{{data.productType}}</td>
                    <td scope="row">{{data.brand.brandName}}</td>
                </tr>
            </table>
            <table class="table" border="1px">
                <tr>
                    <th scope="col">Store Name</th>
                    <th scope="col">Store Location</th>
                </tr>
                <tr *ngFor="let d of Data">
                    <td scope="row">{{d.storeName}}</td>
                    <td scope="row">{{d.storeLocation}}</td>
                </tr>
            </table>
            <p>Product Name: <input class="form-control" [(ngModel)]="productInstance.product.productName" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Product Price: <input class="form-control" [(ngModel)]="productInstance.price" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Product Quantity: <input class="form-control" [(ngModel)]="productInstance.quantity" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p>Store Name: <input class="form-control" [(ngModel)]="store.storeName" [ngModelOptions]="{standalone: true}" type="text"></p>
            <p><input class="form-control" type="submit" value="Submit"/></p>
        </form>
    </div>
</div>
`,
providers:[ServiceAddProductToStore, ServiceShowStoresOfSystem]
})
export class ConsumeAddProductToStore implements OnInit,ProductInstance, Product, Stores, Brand
{
    id : any;
    price : any;
    product : Product;
    store : Stores;
    cart : Cart;
    counter : any;
    quantity : any;

    productName : any;
    productCategory : any;
    productType : any;
    brand : Brand;
    productPriceMax : any;
    productPriceMin : any;

    storeName: any;
    storeLocation: any;
    type : any;
    user : User;

    brandName : any;

    productInstance : ProductInstance;

    recivedData: any;
    Data : any;
    ngOnInit() {
        this.product = {productName : this.productName, productCategory : this.productCategory, productType : this.productType, brand : this.brand, productPriceMax : this.productPriceMax, productPriceMin : this.productPriceMin};
        this.store = {productInstance : this.productInstance, storeLocation : this.storeLocation, storeName : this.storeName, user : this.user};
        this.productInstance = {id : this.id, price : this.price, product : this.product, store : this.store, cart : this.cart, counter : this.counter, quantity : this.quantity };
        this.brand = {brandName : this.brandName, product : this.product};
        
        this.get_stores();
        this.get_product();
    }
    constructor(private object : ServiceShowStoresOfSystem,private storage:LocalStorageService, private router : Router, private route : ActivatedRoute, private serviceObject : ServiceAddProductToStore)
    {
        this.get_product();

    }
    get_stores()
    {
        this.object.get().subscribe(data =>{this.Data = data});
    }
    get_product()
    {
        this.serviceObject.get_product().subscribe(data =>{this.recivedData=data;});
    }
    onSubmit()
    {
        this.user = this.storage.retrieve('reciveData');
        console.log(this.user);
        this.serviceObject.send(this.productInstance, this.user, this.store).subscribe(
            value => {
              console.log('[POST] create Customer successfully', value);
            });
        //this.router.navigate(['/AddProductToSystem', {  }], { relativeTo: this.route});
    }
}