import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Stock} from '../models/stock';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {StockFilter} from '../models/stock-filter';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  url = 'http://localhost:8082/chart-service-core/stock/';
  headers = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};

  constructor(private http: HttpClient) {
  }

  getStocks(sf: StockFilter): Observable<Stock[]> {
    return this.http.post<Stock[]>(this.url + 'get-by-company', JSON.stringify(sf), this.headers);
  }

  addStock(s: Stock): any {
    return this.http.post(this.url + 'add', JSON.stringify(s), this.headers);
  }

}
