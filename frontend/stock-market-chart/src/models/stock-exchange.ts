import {Contact} from './contact';

export class StockExchange {
  id: number;
  name: string;
  brief: string;
  remarks: string;
  contact: Contact;

  constructor() {
    this.name = '';
    this.brief = '';
    this.remarks = '';
  }
}
