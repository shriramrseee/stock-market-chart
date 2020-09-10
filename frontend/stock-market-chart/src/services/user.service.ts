import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../models/user';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'http://localhost:8082/user/';
  headers = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  token = '';
  type = '';

  constructor(private http: HttpClient) {
  }

  addUser(s: User): any {
    return this.http.post(this.url + 'add', JSON.stringify(s), this.headers);
  }

  loginUser(s: User): any {
    return this.http.post(this.url + 'authenticate', JSON.stringify(s), this.headers);
  }

  logoutUser(s: User): any {
    return this.http.post(this.url + 'logout', JSON.stringify(s), this.headers);
  }

  checkUser(s: string): any {
    return this.http.post(this.url + 'check', JSON.stringify(s), this.headers);
  }

}
