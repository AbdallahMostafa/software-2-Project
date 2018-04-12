import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class ServiceAdminLogin
{

    constructor(private _http:Http)
    {}

    get(userName: any, password: any)
    {
        let data=new URLSearchParams();
        data.append('userName', userName);
        data.append('password', password);
        console.log(data);
        return this._http.post("http://localhost:8080/AdminLogin",data).map(reault=>reault.json());
    }
}