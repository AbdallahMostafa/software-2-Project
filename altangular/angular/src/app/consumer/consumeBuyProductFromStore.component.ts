import {Component, OnInit} from '@angular/core';
import {ServiceBuyProductFromStore} from '../service/serviceBuyProductFromStore.component';
import 'rxjs/add/operator/map';
import { componentFactoryName } from '@angular/compiler';
import { ActivatedRoute, Router } from '@angular/router';
import {Stores} from '../interface/store';
import { User } from '../interface/userInterFace';
import { Product } from '../interface/product';
import { Brand } from '../interface/brand';
import { Cart } from '../interface/cart';
import { ProductInstance } from '../interface/productInstance';
import { ServiceShowStoresOfSystem } from '../service/serviceShowStoresOfSystem.component';

@Component
({
selector:'show-store',
template:`
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <script src="./app/JS/button.js"></script>
<div class="container">
    <div *ngFor="let data of reciveData">
        <p>{{data.product.productName}}</p>
        <p>{{data.price}}</p>
        <p>{{data.counter}}</p>
        <div class="row" >
            <div class="col-lg-2">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                            <span class="glyphicon glyphicon-minus"></span>
                        </button>
                    </span>
                    <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
                    <span class="input-group-btn">
                        <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                            <span class="glyphicon glyphicon-plus"></span>
                        </button>
                    </span>
                </div>
            </div>
        </div>
        
    </div>
</div>

`,
providers:[ServiceBuyProductFromStore]
})
export class ConsumeBuyProdcutFromStore implements OnInit , User, Product, Cart,ProductInstance

{
    user : User;
    userName: any;
    passWord: any;
    name: any;
    email : any;
    collaborator : any;

    id : any;
    price : any;
    product : Product;
    store : Stores;
    cart : Cart;
    counter : any;
    quantity : any;

    
    cartId : any;
    productInstance : ProductInstance;
    boughtProducts : any;
    
    productName : any;
    productCategory : any;
    productType : any;
    brand : Brand;
    productPriceMax : any;
    productPriceMin : any;

    ngOnInit() {
        this.user = {name: this.name, userName: this.userName, passWord : this.passWord, email : this.email, cart : this.cart, collaborator :this.collaborator }
        this.cart = {boughtProducts : this.boughtProducts, productInstance : this.productInstance, user : this.user, cartId : this.cartId}
        this.productInstance = {cart : this.cart, price : this.price, counter : this.counter, id : this.id, quantity : this.quantity, product : this.product, store: this.store}
        this.product = {brand : this.brand, productCategory : this.productCategory, productName : this.productName, productPriceMax : this.productPriceMax, productPriceMin :this.productPriceMin, productType : this.productType}
    }
    storeName : any;
    reciveData:any;
    constructor(private router: Router, private route: ActivatedRoute,private serviceObject:ServiceBuyProductFromStore, private Object: ServiceShowStoresOfSystem)
    {
        this.storeName = this.route.snapshot.paramMap.get("storeName");
        this.Object.get_porducts(this.storeName).subscribe(data => {this.reciveData = data});
        console.log(this.reciveData);
    }
    show_stores()
    {
        this.serviceObject.get(this.user,this.productInstance).subscribe(data =>{this.reciveData=data;});
    }
}