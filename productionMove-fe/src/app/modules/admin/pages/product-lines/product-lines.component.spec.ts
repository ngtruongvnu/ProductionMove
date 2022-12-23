import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductLinesComponent } from './product-lines.component';

describe('ProductLinesComponent', () => {
  let component: ProductLinesComponent;
  let fixture: ComponentFixture<ProductLinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductLinesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductLinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
