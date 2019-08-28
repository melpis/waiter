import { Injectable } from '@angular/core';
import { ApplicationHttpClient } from './http-client.service';
import { ServiceType } from '../common/service-type.enum';
import { Menu } from '../reservation/shop-info/menu';

@Injectable()
export class MenuService {

  constructor(private http:ApplicationHttpClient) { }

  public getMenuList(storeId:number){
    return this.http.get<Menu[]>(ServiceType.MENU, "/menus/" + storeId);
  }

}
