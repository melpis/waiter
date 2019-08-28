import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShopInfoComponent } from './shop-info/shop-info.component';
import { ReservationRoutingModule } from './reservation.routes';
import { ShopInfoTopComponent } from './shop-info/shop-info-top/shop-info-top.component';
import { ShopMenuComponent } from './shop-info/shop-menu/shop-menu.component';
import { ShopIntroduceComponent } from './shop-info/shop-introduce/shop-introduce.component';
import { ShopReservationComponent } from './shop-info/shop-reservation/shop-reservation.component';
import { ShopFooterComponent } from './shop-info/shop-footer/shop-footer.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    ReservationRoutingModule
  ],
  providers: [],
  declarations: [ShopInfoComponent, ShopInfoTopComponent, ShopMenuComponent, ShopIntroduceComponent, ShopReservationComponent, ShopFooterComponent],
})
export class ReservationModule { }
