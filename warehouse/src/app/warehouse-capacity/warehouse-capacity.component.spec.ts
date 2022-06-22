import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarehouseCapacityComponent } from './warehouse-capacity.component';

describe('WarehouseCapacityComponent', () => {
  let component: WarehouseCapacityComponent;
  let fixture: ComponentFixture<WarehouseCapacityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WarehouseCapacityComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WarehouseCapacityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
