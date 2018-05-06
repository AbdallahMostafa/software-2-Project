import{Injectable} from '@angular/core';
import{Http} from '@angular/http';
import {URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {User} from '../interface/userInterFace';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { HttpModule} from '@angular/http'; 

@Injectable()
export class ServiceAddCollaborators
{
    private headers = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _http:HttpClient)
    {}

    add_collaborators(user : User, collaborator : any): Observable <any> 
    {
        return this._http.post("http://localhost:8080/AddCollaborators",{user , collaborator} , {headers: this.headers});
    }
}