import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewProductlineComponent } from './new-productline.component';

describe('NewProductlineComponent', () => {
  let component: NewProductlineComponent;
  let fixture: ComponentFixture<NewProductlineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewProductlineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewProductlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
