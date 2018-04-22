import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {Brand} from '../interface/brand';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { HttpModule} from '@angular/http'; 

@Injectable()
export class BrandService
{
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:HttpClient)
    {}

    add_brand(brand : Brand): Observable <any> 
    {
        return this._http.post("http://localhost:8080/AddBrandToSystem",brand , {headers: this.headers});
    }
}