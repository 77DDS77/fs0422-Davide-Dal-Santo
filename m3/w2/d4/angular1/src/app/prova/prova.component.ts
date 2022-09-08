import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-prova',
  templateUrl: './prova.component.html',
  styleUrls: ['./prova.component.scss']
})
export class ProvaComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router
  ) { }

  id:number = 1;;
  nome:string = 'Mario';

  ngOnInit(): void {
    this.route.params.subscribe((params:any) => {
      this.id = params.id;
      this.nome = params.nome;
    })
  }

  redirect(){
    this.router.navigate(['/prova', 5, 'Giovanna'])
  }

}

/**
 *
 * params e' come una promise e si gestisce con subscribe
 *
 */
