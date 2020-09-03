
export class User {
  id: number;
  name: string;
  password: string;
  type: string;

  constructor() {
    this.name = '';
    this.password = '';
    this.type = '';
  }
}
