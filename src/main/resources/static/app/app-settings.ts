import { Headers } from '@angular/http';

export class AppSettings {

    public static get API_ENDPOINT():string {
        return 'http://127.0.0.1:8080/api/'; 
    }

    // public static get AUTH_TOKEN_ENDPOINT(): string {
    //     return 'http://127.0.0.1:8000/api-token-auth/';
    // }

    public static get getAuthHeader(): Headers{
        var authHeader: Headers = new Headers();
        authHeader.append('Content-Type', 'application/json');
        return authHeader;
    }

}