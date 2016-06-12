import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES, Router } from '@angular/router-deprecated';
//Project Components

@Component({
    selector: 'navbar-top',
    templateUrl: './app/layout/navbar-top.component.html',
    directives: [ROUTER_DIRECTIVES],
})
export class NavbarTopComponent{

    constructor(
        private _router: Router){

    }

    isCurrentRoute(route){
        var instruction = this._router.generate(route);
        return this._router.isRouteActive(instruction);
    }
}