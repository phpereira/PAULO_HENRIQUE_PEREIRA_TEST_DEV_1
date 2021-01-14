import { TestBed } from '@angular/core/testing';

import { NitryxTestService } from './nitryx-test.service';

describe('NitryxTestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NitryxTestService = TestBed.get(NitryxTestService);
    expect(service).toBeTruthy();
  });
});
