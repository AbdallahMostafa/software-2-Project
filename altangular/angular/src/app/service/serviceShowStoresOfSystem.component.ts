import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class ServiceShowStoresOfSystem{
    private storeName : any;
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:Http,private http: HttpClient)
    {
        
    }
    get()
    {
        let data=new URLSearchParams();
        return this.http.get("http://localhost:8080/showStoresOfSystem",{headers : this.headers});
    }
    
    get_porducts(storeName : any) : any
    {
        let data=new URLSearchParams();
        data.append('storeName',storeName);
        console.log(data);
        return this._http.post("http://localhost:8080/showProductOfStore",data).map(reault=>reault.json());
    }
    get_porduct(storeName : any) : any
    {
        let data=new URLSearchParams();
        data.append('storeName',storeName);
        return this.http.post("http://localhost:8080/showProducts",data,{headers : this.headers});
    }
}