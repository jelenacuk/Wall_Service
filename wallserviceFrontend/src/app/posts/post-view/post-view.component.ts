import { Component, Input, OnInit } from '@angular/core';
import { PostDto } from 'src/app/dto/post-dto';

@Component({
  selector: 'app-post-view',
  templateUrl: './post-view.component.html',
  styleUrls: ['./post-view.component.css']
})
export class PostViewComponent implements OnInit {

  @Input() post: PostDto;
  // rating
  stars: number[] = [1, 2, 3, 4, 5];
  selectedValue: number;
  panelOpenState = false;

  constructor() { }

  ngOnInit() {
  }

  countStar(star) {
    this.selectedValue = star;
  }

}
