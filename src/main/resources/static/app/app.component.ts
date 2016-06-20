import { Component } from '@angular/core';
import { RouteConfig, RouterOutlet } from '@angular/router-deprecated';
//Project Components
import { DashboardComponent } from './layout/dashboard.component'; //location is temporary
import { NavbarTopComponent } from './layout/navbar-top.component';
import { UserComponent } from './users/user.component';
import { UserFormComponent } from './users/user-form.component';
@RouteConfig([
    { path: '/', name: 'Dashboard', component: DashboardComponent, useAsDefault:true},
    { path: '/users', name: 'Users', component: UserComponent},
    { path: '/users/new', name: 'NewUser', component: UserFormComponent},
    { path: '/users/:id', name: 'EditUser', component: UserFormComponent},
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