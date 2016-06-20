import { Component, OnInit } from '@angular/core';
import { Router, RouteParams } from '@angular/router-deprecated';
import { FormBuilder, ControlGroup, Validators } from '@angular/common';

//Project Components
import { User } from '../users/user.model';
import { AlertComponent, Alert } from '../shared/alert.component';

@Component({
    templateUrl: './app/users/user-form.component.html',
    directives: [AlertComponent],
})
export class UserFormComponent implements OnInit{
	
	user = new User();
	userForm: ControlGroup;
	userTitleForm: string;

	userAlert = new Alert();

	constructor(
		_fb: FormBuilder,
		private _router: Router,
		private _routeParams: RouteParams
		){
		this.userForm = _fb.group({
			first_name: ['', Validators.required],
			last_name: ['', Validators.required],
			birth_date: [],
			address: []
		})
	}

	ngOnInit(){
		var id = this._routeParams.get('id');
		var isNewUser = this._routeParams.get('isNewUser');

		this.userTitleForm = id? "Edit user" : "Add new user";

		if(!id)
			return;

		//Service method this.user = get user
	}
	cancel(){
		this._router.navigate(['Users']);
	}
	save(){
		if(this.user.id)
			console.log(this.user);
			//service.updateUser(this.user)
			//open alert
		else
			console.log(this.user);
			//service.addUser(this.user)
			//open alert
	}
	closeAlert($event){
		this.userAlert.open = $event.visible;
	}
}