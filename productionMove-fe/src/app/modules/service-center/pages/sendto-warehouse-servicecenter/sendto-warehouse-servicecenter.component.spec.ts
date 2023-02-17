import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendtoWarehouseServicecenterComponent } from './sendto-warehouse-servicecenter.component';

describe('SendtoWarehouseServicecenterComponent', () => {
  let component: SendtoWarehouseServicecenterComponent;
  let fixture: ComponentFixture<SendtoWarehouseServicecenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendtoWarehouseServicecenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SendtoWarehouseServicecenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
