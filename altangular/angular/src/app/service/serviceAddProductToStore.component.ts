import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {User} from '../interface/userInterFace';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { HttpModule} from '@angular/http';
import {ProductInstance} from '../interface/productInstance';
import { Stores } from '../interface/store';
import { Product } from '../interface/product';
import { Brand } from '../interface/brand';
@Injectable()
export class ServiceAddProductToStore
{

    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private http:HttpClient,private _http:Http)
    {}
    get_product()
    {
        let data=new URLSearchParams();
        return this._http.post("http://localhost:8080/ShowProduct",data).map(reault=>reault.json());
    }
    send(product : Product , user : User, store : Stores,productInstance : ProductInstance) : Observable <any>
    {
        return this.http.post("http://localhost:8080/AssignProductToStore",{product, user, store, productInstance} ,{headers : this.headers});
    }
}