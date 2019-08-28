import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Menu } from './menu';
import { MenuService } from '../../service/menu.service';
import { ServiceType } from '../../common/service-type.enum';
import { StoreService } from '../../service/store.service';
import { Store } from '../../store/store';

@Component({
  selector: 'app-shop-info',
  templateUrl: './shop-info.component.html',
  styleUrls: ['./shop-info.component.css']
})
export class ShopInfoComponent implements OnInit {

  constructor(private route:ActivatedRoute, private menuService:MenuService, private storeService:StoreService) { }

  storeId:number;

  menus:Menu[];
  store:Store;

  initStore(){
      this.storeService.getStoreInfo(this.storeId).subscribe( res =>{
          this.store = res;
      })
  }
  initMenus(){
    this.menuService.getMenuList(this.storeId).subscribe(res =>{
        this.menus = res;
    }) ;
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
        this.storeId = params['id'];
        if(!this.storeId){ this.storeId = 1; }
        this.initMenus();
        this.initStore();
    })
  }



}
