import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import {
  NgbCarousel,
  NgbDropdown,
  NgbModule,
} from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CertificationComponent } from './components/certification/certification.component';
import { UserFeedComponent } from './components/user-feed/user-feed.component';
import { AuthInterceptor } from './intercept/auth-interceptor';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { InsightsDashboardComponent } from './components/insights-dashboard/insights-dashboard.component';
import { AdminComponent } from './components/admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    ProfileComponent,
    CertificationComponent,
    UserFeedComponent,
    SignUpComponent,
    InsightsDashboardComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule
  ],
  providers: [
    provideClientHydration(),
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
