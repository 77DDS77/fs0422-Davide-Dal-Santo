import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-utenti-dettaglio',
  templateUrl: './utenti-dettaglio.component.html',
  styleUrls: ['./utenti-dettaglio.component.scss']
})
export class UtentiDettaglioComponent implements OnInit {

  constructor(private route:ActivatedRoute) { }

  userId!:Params;

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    console.log(this.userId);

  }

}

/**
 * Com e passare e leggere un dettaglio (utente in questoi caso)
 *
 *
 *
 */
