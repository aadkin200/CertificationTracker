import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CertificationComponent } from './components/certification/certification.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AllCertificationComponent } from './components/all-certification/all-certification.component';
import { LoginComponent } from './components/login/login.component';
import { UserFeedComponent } from './components/user-feed/user-feed.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { InsightsDashboardComponent } from './components/insights-dashboard/insights-dashboard.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'certifications', component: CertificationComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'all-certification', component: AllCertificationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'user-feed', component: UserFeedComponent },
  { path: 'insight-dashboard', component: InsightsDashboardComponent },
  { path: 'home/sign-up', component: SignUpComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
