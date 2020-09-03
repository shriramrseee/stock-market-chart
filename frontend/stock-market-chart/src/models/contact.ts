
export class Contact {
  id: number;
  city: string;
  email: string;
  phone: string;
  state: string;
  zip: string;

  constructor() {
    this.city = '';
    this.email = '';
    this.phone = '';
    this.state = '';
    this.zip = '';
  }
}
