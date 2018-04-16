import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {User} from '../interface/userInterFace';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { HttpModule} from '@angular/http'; 
@Injectable()
export class ServiceUserSignUp
{
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:HttpClient)
    {}

    get(normalUser : User): Observable <any> 
    {
        return this._http.post("http://localhost:8080/SignUp",normalUser , {headers: this.headers});
    }

}