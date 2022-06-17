import { TestBed } from '@angular/core/testing';

import { WarehouseCapacityService } from './warehouse-capacity.service';

describe('WarehouseCapacityService', () => {
  let service: WarehouseCapacityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WarehouseCapacityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
