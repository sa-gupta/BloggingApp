import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { AddBookComponent } from './components/add-book/add-book.component';
import { AddPostComponent } from './components/add-post/add-post.component';
import { CommunityPageComponent } from './components/community-page/community-page.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { PostPageComponent } from './components/post-page/post-page.component';
import { ShowBookComponent } from './components/show-book/show-book.component';
import { SignupPageComponent } from './components/signup-page/signup-page.component';
import { SinglePagePostComponent } from './components/single-page-post/single-page-post.component';
import { UpdateBookComponent } from './components/update-book/update-book.component';
import { UpdatePostComponent } from './components/update-post/update-post.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { SinglePageCommunityComponent } from './components/single-page-community/single-page-community.component';
import { AddCommunityComponent } from './components/add-community/add-community.component';

const routes: Routes = [
  {
    path:'add-book', component: AddBookComponent
  },
  {
    path:'add-community', component: AddCommunityComponent
  },
  {
    path: ':id/add-post', component: AddPostComponent
  },
  {
    path: 'update-post/:id' , component: UpdatePostComponent
  },
  {
    path:'update-book/:id', component: UpdateBookComponent
  },
  {
    path:'show-all', component: ShowBookComponent
  },
  {
    path:'posts', component: PostPageComponent
  },
  {
    path:'login', component: LoginPageComponent
  },
  {
    path:'signup', component: SignupPageComponent
  },
  {
    path:'communities', component: CommunityPageComponent
  },
  {
    path:'about-us', component: AboutUsComponent
  },
  {
    path:'contact-us', component: ContactUsComponent
  },
  {
    path:'home', component: HomePageComponent
  },
  {
    path:'post/:id', component: SinglePagePostComponent
  },
  {
    path:'community/:id', component: SinglePageCommunityComponent
  },
  {
    path:'user/:role/:id', component: UserProfileComponent
  },
  
  {path: '', redirectTo: '/home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    scrollPositionRestoration: 'enabled',
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
