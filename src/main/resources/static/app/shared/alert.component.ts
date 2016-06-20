import {Component, Input, Output, EventEmitter} from '@angular/core'

@Component({
    selector: 'alert',
    template: `
    <div class="alert alert-dismissible" *ngIf="visible" [ngClass]="{
      'alert-danger': alertType == 'danger',
      'alert-success': alertType == 'success',
      'alert-warning': alertType == 'warning',
      'alert-info': alertType == 'info'
    }">
      <button type="button" class="close" (click)="closeAlert()" >&times;</button>
      {{alertMessage}}

    </div>
    `,

})
export class AlertComponent{
    // alertType = "danger";
    @Input() alertType = "danger";
    @Input() alertMessage: string = "Something's Wrong! Please Contact the administrator...";
    @Input() visible = true;

    @Output() close = new EventEmitter();

    closeAlert(){
        this.close.emit({visible: false});
    }
}

export class Alert{
    message: string = "Something's Wrong!, Please contact the administrator";
    type: string = "success";
    open: boolean = false;
}