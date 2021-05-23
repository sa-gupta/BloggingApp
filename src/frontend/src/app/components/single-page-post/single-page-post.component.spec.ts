import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SinglePagePostComponent } from './single-page-post.component';

describe('SinglePagePostComponent', () => {
  let component: SinglePagePostComponent;
  let fixture: ComponentFixture<SinglePagePostComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SinglePagePostComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SinglePagePostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
