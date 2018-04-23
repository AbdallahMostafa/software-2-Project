import { Inject, Injectable, InjectionToken } from '@angular/core';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
import {User} from '../interface/userInterFace';
import {Cart} from '../interface/cart';
export const MY_AWESOME_SERVICE_STORAGE =
new InjectionToken<StorageService>('MY_AWESOME_SERVICE_STORAGE');
@Injectable()
export class MyAwesomeService {
 
    user : User;
     
    constructor(@Inject(SESSION_STORAGE) private storage: StorageService) {
    }
 
    public setSession(userObject : User):any {
        let STORAGE_KEY = "Object";
        let session = this.storage.set(STORAGE_KEY, userObject );
        return session;
    }
    public getSession(key:any):any {
        let session = this.storage.get(key);
        return session;
    }
}