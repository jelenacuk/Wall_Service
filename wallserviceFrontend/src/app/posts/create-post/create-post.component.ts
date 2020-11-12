import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { NewPostDto } from 'src/app/dto/new-post-dto';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  private text: string;

  constructor( private postService: PostService, private snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  publishPost() {
    const dto: NewPostDto = new NewPostDto();
    dto.text = this.text;
    dto.creationDate = new Date();
    console.log(dto.creationDate);
    this.postService.createPost(dto).subscribe(
      (response => {
        if (response === true) {
          this.snackBar.open('Published');
          this.text = '';
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

}
