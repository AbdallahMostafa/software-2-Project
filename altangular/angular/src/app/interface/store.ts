import {User} from './userInterFace';
import {ProductInstance} from './productInstance';
export interface Stores
{
    storeName: any;
    storeLocation: any;
    type : any;
    user : User;
    productInstance : ProductInstance;  
}