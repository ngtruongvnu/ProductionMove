import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecallProductComponent } from './recall-product.component';

describe('RecallProductComponent', () => {
  let component: RecallProductComponent;
  let fixture: ComponentFixture<RecallProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecallProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecallProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
