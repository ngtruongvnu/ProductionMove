import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiveFromServicecenterComponent } from './receive-from-servicecenter.component';

describe('ReceiveFromServicecenterComponent', () => {
  let component: ReceiveFromServicecenterComponent;
  let fixture: ComponentFixture<ReceiveFromServicecenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceiveFromServicecenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReceiveFromServicecenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
