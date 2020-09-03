
export class IPO {
  id: number;
  closeDate: string;
  openDate: string;
  remarks: string;
  price: number;
  count: number;

  constructor() {
   this.closeDate = '2020-01-01 00:00:00';
   this.openDate = '2020-01-01 00:00:00';
   this.remarks = '';
   this.price = 0;
   this.count = 0;
  }
}
