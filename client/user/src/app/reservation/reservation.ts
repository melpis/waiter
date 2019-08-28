import { Store } from "../store/store";

export class Reservation {
    storeId:number;
    userName:string;
    reservationDate:string;
    userCount:number;
    contactNumber:string;
    message:string;

    constructor(store:Store){
        if (store) {
            this.storeId = store.id;
        }
    }
}
