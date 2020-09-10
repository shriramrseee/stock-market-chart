export class JwtResponse {
    token: string;
    type: string;

    constructor() {
        this.token = '';
        this.type = '';
    }
}