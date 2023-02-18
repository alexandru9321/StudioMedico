import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertPrenotazioneComponent } from './insert-prenotazione.component';

describe('InsertPrenotazioneComponent', () => {
  let component: InsertPrenotazioneComponent;
  let fixture: ComponentFixture<InsertPrenotazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertPrenotazioneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertPrenotazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
