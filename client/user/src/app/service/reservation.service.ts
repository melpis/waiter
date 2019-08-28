import { Injectable } from '@angular/core';
import { ApplicationHttpClient } from './http-client.service';
import { Reservation } from '../reservation/reservation';
import { Observable } from 'rxjs';
import { ServiceType } from '../common/service-type.enum';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:ApplicationHttpClient) { }

  public post(reservation:Reservation):Observable<Reservation>{
    return this.http.post(ServiceType.RESERVATION, "/post", reservation);
  }
}
