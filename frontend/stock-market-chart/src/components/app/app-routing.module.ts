import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from '../user/user.component';
import {ContentComponent} from '../content/content.component';
import {AuthGuard} from './auth.guard';

const routes: Routes = [
  { path: 'login', component: UserComponent },
  { path: 'content', component: ContentComponent, canActivate: [AuthGuard]},
  { path: '**', component: UserComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
