import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImpossibleFixProductComponent } from './impossible-fix-product.component';

describe('ImpossibleFixProductComponent', () => {
  let component: ImpossibleFixProductComponent;
  let fixture: ComponentFixture<ImpossibleFixProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImpossibleFixProductComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImpossibleFixProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
