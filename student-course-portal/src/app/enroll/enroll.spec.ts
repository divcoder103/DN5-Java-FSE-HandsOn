import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Enroll } from './enroll';

describe('Enroll', () => {
  let component: Enroll;
  let fixture: ComponentFixture<Enroll>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Enroll],
    }).compileComponents();

    fixture = TestBed.createComponent(Enroll);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
