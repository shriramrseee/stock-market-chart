import {Component, OnInit} from '@angular/core';
import {User} from '../../models/user';
import {UserService} from '../../services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import { JwtResponse } from '../../models/jwt-response';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  formUser: User;
  formUser1: User;
  jwtResponse: JwtResponse;

  constructor(private userService: UserService
            , private router: Router) {
    this.initForm();
  }

  ngOnInit(): void {
  }

  initForm(): void {
    this.formUser = new User();
    this.formUser1 = new User();
  }

  login(): void {
    this.userService.loginUser(this.formUser).subscribe(res => {
      this.jwtResponse = res;
      this.userService.type = this.jwtResponse.type;
      this.userService.token = 'Bearer '+ this.jwtResponse.token;
      sessionStorage.setItem('token', this.userService.token);
      
      this.router.navigate(['/content']);
      this.initForm();
    });
  }

  register(): void {
    this.userService.addUser(this.formUser1).subscribe(res => {
      this.initForm();
    });
  }

}
