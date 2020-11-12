import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewPostDto } from '../dto/new-post-dto';
import { ConstantsService } from './constants.service';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  headers: HttpHeaders = new HttpHeaders({
    Authorization: 'Bearer ' + localStorage.getItem('token')
  });

  constructor( private http: HttpClient, private constants: ConstantsService ) { }

  createPost(dto: NewPostDto): Observable<boolean> {
    return this.http.post<boolean>(this.constants.postsPath + '/create', dto, { headers: this.headers });
  }
}
