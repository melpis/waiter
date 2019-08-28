import { Component, OnInit, Input } from '@angular/core';
import { Store } from '../../../store/store';
import { Menu } from '../menu';
import { ServiceType } from '../../../common/service-type.enum';

@Component({
  selector: 'app-shop-menu',
  templateUrl: './shop-menu.component.html',
  styleUrls: ['./shop-menu.component.css']
})
export class ShopMenuComponent implements OnInit {

  constructor() { }

  @Input() store:Store;
  @Input() menus:Menu[];

  ngOnInit() {
  }

  getMenuServiceUrl(menu:Menu){
    return ServiceType.MENU + menu.imagePath;
  }
}
