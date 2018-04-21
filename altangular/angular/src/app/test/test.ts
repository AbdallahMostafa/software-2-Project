import { Inject, Injectable, InjectionToken } from '@angular/core';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';

export const MY_AWESOME_SERVICE_STORAGE =
new InjectionToken<StorageService>('MY_AWESOME_SERVICE_STORAGE');
@Injectable()
export class MyAwesomeService {
 
    constructor(@Inject(SESSION_STORAGE) private storage: StorageService) {
 
    }
 
    public setStoreOwnerSession(storeName : any):any {
        let STORAGE_KEY = "storeName";
        let session = this.storage.set(STORAGE_KEY, storeName );
        return session;
    }
    public getSession(key:any):any {
        let session = this.storage.get(key);
        return session;
    }
}