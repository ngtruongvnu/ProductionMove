import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductlineDetailComponent } from './productline-detail.component';

describe('ProductlineDetailComponent', () => {
  let component: ProductlineDetailComponent;
  let fixture: ComponentFixture<ProductlineDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductlineDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductlineDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
