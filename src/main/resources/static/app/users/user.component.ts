import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router-deprecated';
//Project Components
import { SpinnerComponent } from '../shared/spinner.component';
import { User } from '../users/user.model'

@Component({
    templateUrl: './app/users/user.component.html',
    directives: [SpinnerComponent, RouterLink],
})
export class UserComponent implements OnInit{

    user: User[]; 
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