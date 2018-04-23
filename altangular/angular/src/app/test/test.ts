import { Inject, Injectable, InjectionToken } from '@angular/core';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
import {User} from '../interface/userInterFace';
export const MY_AWESOME_SERVICE_STORAGE =
new InjectionToken<StorageService>('MY_AWESOME_SERVICE_STORAGE');
@Injectable()
export class MyAwesomeService {
 
    user : User = {name : '', userName : '', passWord : '', email : '', type : ''}
    constructor(@Inject(SESSION_STORAGE) private storage: StorageService) {
 
    }
 
    public setSession(Name : any):any {
        let STORAGE_KEY = "Name";
        let session = this.storage.set(STORAGE_KEY, Name );
        return session;
    }
    public getSession(key:any):any {
        let session = this.storage.get(key);
        return session;
    }
}