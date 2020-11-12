import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConstantsService {
  readonly localhost = 'http://localhost:8080';
  readonly authPath = this.localhost + '/api/auth';
  readonly userPath = this.localhost + '/api/user';
  readonly postsPath = this.localhost + '/api/posts';
}
