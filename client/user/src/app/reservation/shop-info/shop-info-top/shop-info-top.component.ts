import { Component, OnInit, Input } from '@angular/core';
import { Store } from '../../../store/store';

@Component({
  selector: 'app-shop-info-top',
  templateUrl: './shop-info-top.component.html',
  styleUrls: ['./shop-info-top.component.css']
})
export class ShopInfoTopComponent implements OnInit {


  @Input() store:Store;

  constructor() { }

  ngOnInit() {
  }

}
