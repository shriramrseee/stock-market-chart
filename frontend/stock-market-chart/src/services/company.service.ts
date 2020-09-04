import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Company} from '../models/company';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  url = 'http://localhost:8081/company/';
  headers = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};

  constructor(private http: HttpClient) {
  }

  getCompanys(): Observable<Company[]> {
    return this.http.get<Company[]>(this.url + 'all');
  }

  addCompany(s: Company): any {
    return this.http.post(this.url + 'admin/add', JSON.stringify(s), this.headers);
  }

  deleteCompany(id: number): any {
    return this.http.delete(this.url + 'admin/delete/' + id);
  }

  updateCompanyDetails(company: Company): any {
    return this.http.put(this.url + 'admin/update', JSON.stringify(company), this.headers)
  }
}
