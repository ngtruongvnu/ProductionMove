import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GivebackWarrantyProductComponent } from './giveback-warranty-product.component';

describe('GivebackWarrantyProductComponent', () => {
  let component: GivebackWarrantyProductComponent;
  let fixture: ComponentFixture<GivebackWarrantyProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GivebackWarrantyProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GivebackWarrantyProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
