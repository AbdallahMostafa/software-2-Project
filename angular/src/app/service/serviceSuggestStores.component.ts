import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { SuggestStores } from '../interface/suggestStore';

@Injectable()
export class ServiceSuggestStores
{
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:HttpClient)
    {}
    /*get()
    {
        let data=new URLSearchParams();
        return this._http.post("http://localhost:8080/ShowStores",data).map(reault=>reault.json());
    }*/
    send(suugestStores:SuggestStores): Observable<any>{
        return this._http.post("http://localhost:8080/SuggestStore",suugestStores,{headers : this.headers});
    }
}