/**
 * Componente non funzionante, possibilita' che sia posseduto alte.
 *
 * In questo stato dopo i molteplici tentativi VANI
 * di farlo funzionare.
 *
 * Rinuncia completa.
*/

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/Classes/post';
import { AuthService } from 'src/app/Services/auth.service';
import { PostService } from 'src/app/Services/post.service';

@Component({
  selector: 'app-edit-post',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.scss'],
})
export class EditPostComponent implements OnInit {
  postId: number = Number(this.activeRoute.snapshot.paramMap.get('postId'));
  postToEdit!: Post;
  allPosts: Post[] = [];

  editForm = new FormGroup({
    postTitle: new FormControl(''),
    postContent: new FormControl(''),
    postOwner: new FormControl(''),
  });

  constructor(
    private postSvc: PostService,
    private auth: AuthService,
    private router: Router,
    private activeRoute: ActivatedRoute
  ) {  }

  ngOnInit(): void {
    this.postSvc.getAllPosts().subscribe((posts: Post[]) => {
      this.postToEdit = <Post>posts.find((post) => post.id == this.postId)

      if(this.postToEdit){
        this.editForm.setValue({
          postTitle: this.postToEdit.title ,
          postContent: this.postToEdit.content,
          postOwner: this.auth.getLoggedUser().id
        })

      }
    });
  }

  submit() {
    let hold:Post = {
      id: this.postId,
      title: <string>this.editForm.value.postTitle,
      content: <string>this.editForm.value.postContent ,
      ownerId: this.auth.getLoggedUser().id,
      edited: true
    }
    this.postSvc.editPost(hold, this.postId)
    .subscribe(() => {
      this.router.navigate(['/profile', this.auth.getLoggedUser().slug])
    })
  }
}
