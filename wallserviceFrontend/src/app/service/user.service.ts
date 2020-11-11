import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantsService } from './constants.service';
import { LoginDto } from '../dto/login-dto';
import { Observable } from 'rxjs';
import { TokenDto } from '../dto/token-dto';
import { UserDto } from '../dto/user-dto';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor( private http: HttpClient, private constants: ConstantsService ) { }

  registration(dto: UserDto): Observable<UserDto> {
    return this.http.post<UserDto>(this.constants.authPath + '/registration', dto);
  }

  login(dto: LoginDto): Observable<TokenDto> {
    return this.http.post<TokenDto>(this.constants.authPath + '/login', dto);
  }

}
