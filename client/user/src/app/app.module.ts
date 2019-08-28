import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';


import { AppComponent } from './app.component';
import { ReservationModule } from './reservation/reservation.module';
import { AppRoutingModule } from './app.routes';
import { ApplicationHttpClient } from './service/http-client.service';
import { MenuService } from './service/menu.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { StoreService } from './service/store.service';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    ReservationModule
  ],
  providers: [HttpClient, ApplicationHttpClient,MenuService, StoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
