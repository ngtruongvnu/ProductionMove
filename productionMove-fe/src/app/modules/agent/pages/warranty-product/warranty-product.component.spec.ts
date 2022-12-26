import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarrantyProductComponent } from './warranty-product.component';

describe('WarrantyProductComponent', () => {
  let component: WarrantyProductComponent;
  let fixture: ComponentFixture<WarrantyProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WarrantyProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WarrantyProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
