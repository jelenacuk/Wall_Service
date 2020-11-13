import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './app-common/homepage/homepage.component';
import { CreatePostComponent } from './posts/create-post/create-post.component';
import { PostViewComponent } from './posts/post-view/post-view.component';
import { LoginComponent } from './users/login/login.component';
import { RegistrationComponent } from './users/registration/registration.component';


const routes: Routes = [
  {path: 'home', component: HomepageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'create-post', component: CreatePostComponent},
  {path: 'post', component: PostViewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
