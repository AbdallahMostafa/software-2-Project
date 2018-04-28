import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { SuggestStores } from '../interface/suggestStore';
import { User } from '../interface/userInterFace';

@Injectable()
export class ServiceSuggestStores
{
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:HttpClient)
    {}
    send(suggestedStores:SuggestStores, storeOwner : User): Observable<any>{
        return this._http.post("http://localhost:8080/SuggestStore",{suggestedStores, storeOwner},{headers : this.headers});
    }
}