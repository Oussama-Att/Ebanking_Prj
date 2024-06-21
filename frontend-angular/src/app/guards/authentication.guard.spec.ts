import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { authenticationGuard } from './authentication.guard';

describe('authenticationGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => {
    return TestBed.runInInjectionContext(() => {
      // @ts-ignore
      return authenticationGuard(...guardParameters);
    });
  };

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
