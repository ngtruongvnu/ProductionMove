import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticProductComponent } from './statistic-product.component';

describe('StatisticProductComponent', () => {
  let component: StatisticProductComponent;
  let fixture: ComponentFixture<StatisticProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatisticProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
