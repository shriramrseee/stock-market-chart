import {StockExchange} from './stock-exchange';
import {Company} from './company';


export class Stock {
  id: number;
  date: string;
  openPrice: number;
  closePrice: number;
  company: Company;
  stockExchange: StockExchange;

  constructor() {
    this.date = '2020-02-02';
    this.openPrice = 0;
    this.closePrice = 0;
  }
}
