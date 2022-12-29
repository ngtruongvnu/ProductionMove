import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendProductToAgentComponent } from './send-product-to-agent.component';

describe('SendProductToAgentComponent', () => {
  let component: SendProductToAgentComponent;
  let fixture: ComponentFixture<SendProductToAgentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendProductToAgentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SendProductToAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
