import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiveProductErrorComponent } from './receive-product-error.component';

describe('ReceiveProductErrorComponent', () => {
  let component: ReceiveProductErrorComponent;
  let fixture: ComponentFixture<ReceiveProductErrorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceiveProductErrorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReceiveProductErrorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
