import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/Models/post';
import { PostService } from 'src/app/post.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  currentPost!: Post;

  constructor(
    private postSvc:PostService,
    private activeRoute:ActivatedRoute,
    private router:Router
     ) { }


  /**
   * Route e Navigazione 2
   *
   *  this.activeRouter.snapshot.params['id']
   * dentro params metto id perche nelle route
   * ho scritto
   *  path: 'edit/:id'
   * DEVONO COMBACIARE
   *
   * private activeRoute:ActivatedRoute, //contiene info sulla rotta appena caricata
   *
   * private router:Router //permette di forzare la navigazione aka spostare l'utente
   *
   */
  ngOnInit(): void {
    let postId:number = Number(this.activeRoute.snapshot.params['id'])
    let post:Post|null = this.postSvc.getPostById(postId)
    if(post){
      this.currentPost = post
    }else{
      this.router.navigate(['/posts'])
    }
  }

  save(){
    this.postSvc.editPost(this.currentPost);
  }

}
