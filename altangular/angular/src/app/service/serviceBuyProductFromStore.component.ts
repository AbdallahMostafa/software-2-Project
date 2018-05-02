import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {User} from '../interface/userInterFace';
import { ProductInstance } from '../interface/productInstance';

@Injectable()
export class ServiceBuyProductFromStore
{

    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:HttpClient)
    {}

    get(user : User, productInstance: ProductInstance) : Observable <any>
    {
        return this._http.post("http://localhost:8080/Buy",{ user,productInstance }, {headers : this.headers});
    }

}