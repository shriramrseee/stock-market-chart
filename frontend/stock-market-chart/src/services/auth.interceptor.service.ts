import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UserService } from "./user.service";

@Injectable({
    providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {
  
    constructor(public auth: UserService) { }
  
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  
      //Don't add auth header for user requests
      const exclude = 'user';

      if (this.auth.token != '' && req.url.search(exclude) === -1) {
       req = req.clone({
          setHeaders: {
            'Authorization': this.auth.token
          }
        })
        //console.log(req.url + '\n' + this.auth.token);
      }  

      return next.handle(req);
    }  
}