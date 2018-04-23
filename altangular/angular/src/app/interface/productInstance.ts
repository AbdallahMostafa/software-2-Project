import{ Product } from './product';
import { Stores } from './store';
import { Cart } from './cart';
export interface ProductInstance {
    id : any;
    price : any;
    product : Product;
    store : Stores;
    cart : Cart;
    counter : any;
    quantity : any;
}