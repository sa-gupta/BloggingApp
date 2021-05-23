import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NewCmpComponent } from './components/new-cmp/new-cmp.component';
import { ShowComponent } from './components/show/show.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainComponent } from './components/main/main.component';
import { FormsModule } from '@angular/forms';
import { AddBookComponent } from './components/add-book/add-book.component';
import { ShortenPipe } from './pipes/shorten.pipe';
import { ShowBookComponent } from './components/show-book/show-book.component';
import { CommunityPageComponent } from './components/community-page/community-page.component';
import { PostPageComponent } from './components/post-page/post-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { SignupPageComponent } from './components/signup-page/signup-page.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { UpdateBookComponent } from './components/update-book/update-book.component';
import { SinglePagePostComponent } from './components/single-page-post/single-page-post.component';
import { CommentSectionComponent } from './components/comment-section/comment-section.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { UserPostComponent } from './components/user-post/user-post.component';
import { AddPostComponent } from './components/add-post/add-post.component';
import { UpdatePostComponent } from './components/update-post/update-post.component';
import { CommunityCardComponent } from './components/community-card/community-card.component';
import { SinglePageCommunityComponent } from './components/single-page-community/single-page-community.component';
import { AddCommunityComponent } from './components/add-community/add-community.component';

@NgModule({
  declarations: [
    AppComponent,
    NewCmpComponent,
    ShowComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    AddBookComponent,
    ShortenPipe,
    ShowBookComponent,
    CommunityPageComponent,
    PostPageComponent,
    LoginPageComponent,
    SignupPageComponent,
    HomePageComponent,
    ContactUsComponent,
    AboutUsComponent,
    UpdateBookComponent,
    SinglePagePostComponent,
    CommentSectionComponent,
    UserProfileComponent,
    UserPostComponent,
    AddPostComponent,
    UpdatePostComponent,
    CommunityCardComponent,
    SinglePageCommunityComponent,
    AddCommunityComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
