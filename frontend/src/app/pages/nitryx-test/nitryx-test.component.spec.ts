import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NitryxTestComponent } from './nitryx-test.component';

describe('NitryxTestComponent', () => {
  let component: NitryxTestComponent;
  let fixture: ComponentFixture<NitryxTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NitryxTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NitryxTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
