import {Sector} from './sector';
import {StockExchange} from './stock-exchange';
import {IPO} from './ipo';

export class Company {
  id: number;
  name: string;
  brief: string;
  ceo: string;
  sector: Sector;
  stockExchanges: StockExchange[];
  boardOfDirectors: any[];
  ipo: IPO;

  constructor() {
    this.name = '';
    this.brief = '';
    this.ceo = '';
  }
}
