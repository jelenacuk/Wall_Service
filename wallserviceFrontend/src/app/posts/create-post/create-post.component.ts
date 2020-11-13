import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { NewPostDto } from 'src/app/dto/new-post-dto';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {

  @Output() postCreationEvent = new EventEmitter<NewPostDto>();
  private text: string;

  constructor(private postService: PostService, private snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  publishPost() {
    const newPost: NewPostDto = new NewPostDto(this.text, new Date());
    this.postService.createPost(newPost).subscribe(
      (response => {
        if (response === true) {
          this.postCreationEvent.emit(newPost);
          this.snackBar.open('Successfuly published!');
          this.text = '';
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

}
