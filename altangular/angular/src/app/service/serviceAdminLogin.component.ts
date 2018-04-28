import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Admin} from '../interface/admin';
@Injectable()
export class ServiceAdminLogin
{

    private headers = new HttpHeaders({'Content-Type': 'application/json'});
    constructor(private _http:HttpClient)
    {}

    get(admin : Admin) : Observable <any>
    { 
        return this._http.post("http://localhost:8080/AdminLogin",admin, {headers : this.headers});
    }
}