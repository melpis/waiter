import { Component, OnInit, Input } from '@angular/core';
import { Store } from '../../../store/store';

@Component({
  selector: 'app-shop-introduce',
  templateUrl: './shop-introduce.component.html',
  styleUrls: ['./shop-introduce.component.css']
})
export class ShopIntroduceComponent implements OnInit {

  @Input() store:Store;
  constructor() { }

  ngOnInit() {
  }

}
