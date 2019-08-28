import { Injectable } from '@angular/core';
import { ApplicationHttpClient } from './http-client.service';
import { Store } from '../store/store';
import { ServiceType } from '../common/service-type.enum';

@Injectable({
  providedIn: 'root'
})
export class StoreService {
    
  constructor(private http:ApplicationHttpClient) { }

  public getStoreInfo(id:number){
      return this.http.get<Store>(ServiceType.PARTNER,  "/"+id );
  }
}
