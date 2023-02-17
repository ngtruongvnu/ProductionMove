import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecallByBatchComponent } from './recall-by-batch.component';

describe('RecallByBatchComponent', () => {
  let component: RecallByBatchComponent;
  let fixture: ComponentFixture<RecallByBatchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecallByBatchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecallByBatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
