import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { authorizationGuard } from './authorization.guard';

describe('authorizationGuard', () => {
  // @ts-ignore
  // @ts-ignore
  const executeGuard: CanActivateFn = (...guardParameters) => {
    return TestBed.runInInjectionContext(() => {
      // @ts-ignore
      return new authorizationGuard(...guardParameters);
    });
  };

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
