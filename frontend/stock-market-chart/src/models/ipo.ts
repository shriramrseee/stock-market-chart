
export class IPO {
  id: number;
  closeDate: string;
  openDate: string;
  remarks: string;
  price: number;
  count: number;

  constructor() {
   this.closeDate = '';
   this.openDate = '';
   this.remarks = '';
   this.price = 0;
   this.count = 0;
  }
}
