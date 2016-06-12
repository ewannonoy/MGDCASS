import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router-deprecated';
//Project Components

@Component({
    selector: 'navbar-top',
    templateUrl: './app/layout/navbar-top.component.html',
    directives: [ROUTER_DIRECTIVES],
})
export class NavbarTopComponent{ }