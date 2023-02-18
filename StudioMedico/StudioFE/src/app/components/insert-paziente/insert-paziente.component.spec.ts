import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertPazienteComponent } from './insert-paziente.component';

describe('InsertPazienteComponent', () => {
  let component: InsertPazienteComponent;
  let fixture: ComponentFixture<InsertPazienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertPazienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertPazienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
