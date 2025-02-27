import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrmDetailedComponent } from './crm-detailed.component';

describe('CrmDetailedComponent', () => {
  let component: CrmDetailedComponent;
  let fixture: ComponentFixture<CrmDetailedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrmDetailedComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrmDetailedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
