import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetGenresComponent } from './get-genres.component';

describe('GetGenresComponent', () => {
  let component: GetGenresComponent;
  let fixture: ComponentFixture<GetGenresComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetGenresComponent]
    });
    fixture = TestBed.createComponent(GetGenresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
