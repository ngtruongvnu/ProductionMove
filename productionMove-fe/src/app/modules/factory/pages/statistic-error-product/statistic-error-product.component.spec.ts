import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticErrorProductComponent } from './statistic-error-product.component';

describe('StatisticErrorProductComponent', () => {
  let component: StatisticErrorProductComponent;
  let fixture: ComponentFixture<StatisticErrorProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticErrorProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatisticErrorProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
