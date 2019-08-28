import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopReservationComponent } from './shop-reservation.component';

describe('ShopReservationComponent', () => {
  let component: ShopReservationComponent;
  let fixture: ComponentFixture<ShopReservationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopReservationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
