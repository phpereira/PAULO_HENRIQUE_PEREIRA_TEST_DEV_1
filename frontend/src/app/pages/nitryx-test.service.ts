import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NitryxTestService {

  constructor(
    private httpClient: HttpClient,
  ) {}

  public findAllCompanies(): Observable<any> {
    return this.httpClient.get(`http://localhost:8080/company`)
  }
}
