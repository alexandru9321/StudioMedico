import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CercaPazienteComponent } from './cerca-paziente.component';

describe('CercaPazienteComponent', () => {
  let component: CercaPazienteComponent;
  let fixture: ComponentFixture<CercaPazienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CercaPazienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CercaPazienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
