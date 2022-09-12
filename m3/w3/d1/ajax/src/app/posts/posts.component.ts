import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import { PostService } from '../post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  constructor(private postSvc: PostService) { }

  posts:Post[] = [];
  post:Post = new Post('', '');

  formAction:string = 'create'

  ngOnInit(): void {
    this.postSvc.getAllPosts().subscribe(posts => this.posts = posts)
  }

  /**
   * qui richiamo il metodo del service
   * e come aggiungevo il .then aggiungo il
   * .subscribe
   */
  save(){
    this.postSvc.addPost(this.post).subscribe(res => {
      this.posts.push(res)
      this.post = new Post('', '');
    });
  }

  deletePost(post: Post){
    this.postSvc.deletePost(post).subscribe(res => {
      let index = this.posts.findIndex(p => p.id === post.id)
      this.posts.splice(index,1)
    })
  }

  editPost(){
    this.postSvc.editPost(this.post).subscribe(res => {
      let index = this.posts.findIndex(p => p.id === this.post.id)
      this.posts.splice(index,1, this.post)
      this.formAction = 'create';
      this.post = new Post('', '');
    })
  }

  selectPost(post:Post){
    this.post = Object.assign({},post)
    this.formAction = 'edit'
  }
}
