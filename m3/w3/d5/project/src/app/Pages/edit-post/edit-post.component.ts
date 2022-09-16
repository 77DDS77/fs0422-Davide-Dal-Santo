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
  editForm!: FormGroup;
  postId: number = Number(this.activeRoute.snapshot.paramMap.get('postId'));
  postToEdit!: Post;

  constructor(
    private postSvc: PostService,
    private auth: AuthService,
    private router: Router,
    private activeRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // this.getPostData(this.postId)
    this.postSvc.getPostById(this.postId).subscribe((post) => {
      this.postToEdit = post;
      console.log(this.postToEdit);
      console.log(post);
    });
    console.log(this.postId);
    console.log(this.postToEdit);
  }

  ngDoCheck(): void {
    console.log(this.postToEdit);
    this.editForm = new FormGroup({
      postTitle: new FormControl(this.postToEdit.title),
      postContent: new FormControl(this.postToEdit.content),
      postOwner: new FormControl(this.auth.getLoggedUser().id),
    });
  }

  getPostData(id: number) {
    this.postSvc.getPostById(id).subscribe((post) => {
      console.log(post);
      if (post) {
        this.postToEdit = post;
        console.log(this.postToEdit);
      }
    });
  }

  submit() {
  }
}
