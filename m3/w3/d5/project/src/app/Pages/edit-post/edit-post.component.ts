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
  postToEdit!: Post|undefined;
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
      this.postToEdit = posts.find((post) => post.id == this.postId)

      if(this.postToEdit){
        this.editForm.setValue({
          postTitle: this.postToEdit.title ,
          postContent: this.postToEdit.content,
          postOwner: this.auth.getLoggedUser().id
        })

      }
    });
  }

  submit() {}
}
