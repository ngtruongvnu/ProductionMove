import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellProductStatisticComponent } from './sell-product-statistic.component';

describe('SellProductStatisticComponent', () => {
  let component: SellProductStatisticComponent;
  let fixture: ComponentFixture<SellProductStatisticComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SellProductStatisticComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SellProductStatisticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
