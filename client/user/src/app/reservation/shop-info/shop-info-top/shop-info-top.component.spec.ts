import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopInfoTopComponent } from './shop-info-top.component';

describe('ShopInfoTopComponent', () => {
  let component: ShopInfoTopComponent;
  let fixture: ComponentFixture<ShopInfoTopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopInfoTopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopInfoTopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
