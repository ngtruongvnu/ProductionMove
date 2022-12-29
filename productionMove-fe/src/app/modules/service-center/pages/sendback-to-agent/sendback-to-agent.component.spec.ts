import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendbackToAgentComponent } from './sendback-to-agent.component';

describe('SendbackToAgentComponent', () => {
  let component: SendbackToAgentComponent;
  let fixture: ComponentFixture<SendbackToAgentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendbackToAgentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SendbackToAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
