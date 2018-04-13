import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ServiceShowStoresOfSystem{
    constructor(private _http:Http)
    {
        
    }
    get()
    {
        let data=new URLSearchParams();
        return this._http.post("http://localhost:8080/showStoresOfSystem",data).map(reault=>reault.json());
    }
}