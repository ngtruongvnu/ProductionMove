import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedWarrantyProductComponent } from './need-warranty-product.component';

describe('NeedWarrantyProductComponent', () => {
  let component: NeedWarrantyProductComponent;
  let fixture: ComponentFixture<NeedWarrantyProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeedWarrantyProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NeedWarrantyProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
