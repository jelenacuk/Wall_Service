import { Component, OnInit } from '@angular/core';
import { MatSnackBar, PageEvent } from '@angular/material';
import { PostDto } from 'src/app/dto/post-dto';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  private posts: PostDto[];
  private page: PageEvent = new PageEvent();

  constructor(private postServise: PostService, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.page.pageIndex = 0;
    this.page.pageSize = 8;
    this.getPosts();
  }

  nextPage($event) {
    this.page = $event;
    this.getPosts();
  }

  getPosts() {
    this.postServise.getPosts(this.page).subscribe(
      (response => {
        if (response !== null) {
          this.posts = response;
          this.posts.length > 0 ? this.page.length = this.posts[0].size : this.page.length = 0;
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  addPost($event) {
    this.posts.unshift($event);
  }

}
