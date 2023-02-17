import { TestBed } from '@angular/core/testing';

import { ProductBatchesService } from './product-batches.service';

describe('ProductBatchesService', () => {
  let service: ProductBatchesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductBatchesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
