import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ServiceAcceptStores
{

    constructor(private _http:Http)
    {}
    get()
    {
        let data=new URLSearchParams();
        return this._http.post("http://localhost:8080/ShowStores",data).map(reault=>reault.json());
    }
    send(storeName:any){
        let dataOfStore = new URLSearchParams();
        dataOfStore.append("storeName",storeName);
        console.log(dataOfStore);
        return this._http.post("http://localhost:8080/AcceptStore",dataOfStore).map(res=>res.json());
    }
}