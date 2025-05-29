import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavingsSummaryComponent } from './savings-summary.component';

describe('SavingsSummaryComponent', () => {
  let component: SavingsSummaryComponent;
  let fixture: ComponentFixture<SavingsSummaryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SavingsSummaryComponent]
    });
    fixture = TestBed.createComponent(SavingsSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
