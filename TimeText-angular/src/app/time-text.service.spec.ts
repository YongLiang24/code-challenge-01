import { TestBed } from '@angular/core/testing';

import { TimeTextService } from './time-text.service';

describe('TimeTextService', () => {
  let service: TimeTextService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TimeTextService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
