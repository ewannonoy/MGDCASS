import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router-deprecated';
//Project Components
import { SpinnerComponent } from '../shared/spinner.component';

@Component({
    templateUrl: './app/users/user.component.html',
    directives: [SpinnerComponent],
})
export class UserComponent implements OnInit{

    isUsersLoading: Boolean;

    constructor(
        private _router: Router){
    }
    ngOnInit(){
        this.loadUsers();
    }

    loadUsers(){
        this.isUsersLoading = true;
    }

}