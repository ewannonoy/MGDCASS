import { Component } from '@angular/core';
import { RouteConfig, RouterOutlet } from '@angular/router-deprecated';
//Project Components
import { DashboardComponent } from './layout/dashboard.component'; //location is temporary
import { NavbarTopComponent } from './layout/navbar-top.component';
import { UserComponent } from './users/user.component';
@RouteConfig([
    { path: '/', name: 'Dashboard', component: DashboardComponent, useAsDefault:true},
    { path: '/users', name: 'Users', component: UserComponent},
    { path: '/*other', name:'Other', redirectTo: ['Dashboard']},
])
@Component({
    selector: 'my-app',
    template: `
        <navbar-top></navbar-top>
        <div class="container" style="margin-top:70px">
            <router-outlet></router-outlet>
        </div>
    `,
    directives: [NavbarTopComponent, RouterOutlet]
})
export class AppComponent { }