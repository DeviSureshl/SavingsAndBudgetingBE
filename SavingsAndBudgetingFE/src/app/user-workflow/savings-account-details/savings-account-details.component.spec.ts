import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavingsAccountDetailsComponent } from './savings-account-details.component';

describe('SavingsAccountDetailsComponent', () => {
  let component: SavingsAccountDetailsComponent;
  let fixture: ComponentFixture<SavingsAccountDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SavingsAccountDetailsComponent]
    });
    fixture = TestBed.createComponent(SavingsAccountDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
