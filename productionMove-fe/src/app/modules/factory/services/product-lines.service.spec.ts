import { TestBed } from '@angular/core/testing';

import { ProductLinesService } from './product-lines.service';

describe('ProductLinesService', () => {
  let service: ProductLinesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductLinesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
