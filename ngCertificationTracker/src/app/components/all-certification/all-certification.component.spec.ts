import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCertificationComponent } from './all-certification.component';

describe('AllCertificationComponent', () => {
  let component: AllCertificationComponent;
  let fixture: ComponentFixture<AllCertificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AllCertificationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllCertificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
