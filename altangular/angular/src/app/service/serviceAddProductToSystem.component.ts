import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {Product} from '../interface/product';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { HttpModule} from '@angular/http'; 
@Injectable()
export class ServiceAddProductToSystem
{
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:HttpClient, private http : Http)
    {}

    add_product(product : Product): Observable <any> 
    {
        return this._http.post("http://localhost:8080/AddProductToSystem",product , {headers: this.headers});
    }
    get_brands() 
    {
        return this.http.get("http://localhost:8080/showBrands");
    }
}