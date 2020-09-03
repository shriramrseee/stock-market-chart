
export class StockFilter {
  companyId: number;
  from: string;
  to: string;

  constructor() {
    this.companyId = 1;
    this.from = '2020-01-01';
    this.to = '2020-12-31';
  }
}
