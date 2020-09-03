import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Sector} from '../models/sector';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SectorService {

  url = 'http://localhost:8081/sector/';
  headers = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};

  constructor(private http: HttpClient) {
  }

  getSectors(): Observable<Sector[]> {
    return this.http.get<Sector[]>(this.url + 'all');
  }

  addSector(s: Sector): any {
    return this.http.post(this.url + 'admin/add', JSON.stringify(s), this.headers);
  }

}
