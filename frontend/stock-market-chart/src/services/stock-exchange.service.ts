import {HttpClient, HttpHeaders} from '@angular/common/http';
import {StockExchange} from '../models/stock-exchange';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StockExchangeService {

  url = 'http://localhost:8082/chart-service-core/stock-exchange/';
  headers = { headers: new HttpHeaders({ 'Content-Type': 'application/json' })};

  constructor(private http: HttpClient) {
  }

  getStockExchanges(): Observable<StockExchange[]> {
    return this.http.get<StockExchange[]>(this.url + 'all');
  }

  addStockExchange(s: StockExchange): any {
    return this.http.post(this.url + 'admin/add', JSON.stringify(s), this.headers);
  }

}
