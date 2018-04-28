import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ServiceShowStoresOfSystem{
    private storeName : any;
    constructor(private _http:Http)
    {
        
    }
    get()
    {
        let data=new URLSearchParams();
        return this._http.post("http://localhost:8080/showStoresOfSystem",data).map(reault=>reault.json());
    }
    get_porducts(storeName : any) : any
    {
        // storeName = this.getStoreName();
        console.log(storeName);
        let data=new URLSearchParams();
        data.append('storeName',storeName);
        return this._http.post("http://localhost:8080/showProductOfStore",data).map(reault=>reault.json());
    }
}