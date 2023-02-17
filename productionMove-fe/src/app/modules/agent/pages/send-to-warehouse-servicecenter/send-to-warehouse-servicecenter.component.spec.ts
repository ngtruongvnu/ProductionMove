import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendToWarehouseServicecenterComponent } from './send-to-warehouse-servicecenter.component';

describe('SendToWarehouseServicecenterComponent', () => {
  let component: SendToWarehouseServicecenterComponent;
  let fixture: ComponentFixture<SendToWarehouseServicecenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendToWarehouseServicecenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SendToWarehouseServicecenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
