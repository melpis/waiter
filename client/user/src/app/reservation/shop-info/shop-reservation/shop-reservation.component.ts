import { Component, OnInit, Input } from '@angular/core';
import { Store } from '../../../store/store';
import { Reservation } from '../../reservation';
import { ReservationService } from '../../../service/reservation.service';

@Component({
  selector: 'app-shop-reservation',
  templateUrl: './shop-reservation.component.html',
  styleUrls: ['./shop-reservation.component.css']
})
export class ShopReservationComponent implements OnInit {

  @Input() store:Store;

  reservation:Reservation;
  constructor(private reservationService:ReservationService) { }

  ngOnInit() {
    this.reservation = new Reservation(this.store)
  }

  post(){
    this.reservationService.post(this.reservation).subscribe( res=>{
      alert("예약 되었습니다.");
      this.reservation = new Reservation(this.store)
    });
      
  }

}
