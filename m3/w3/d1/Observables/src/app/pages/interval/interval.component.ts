import { Component, OnInit } from '@angular/core';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-interval',
  templateUrl: './interval.component.html',
  styleUrls: ['./interval.component.scss']
})
export class IntervalComponent implements OnInit {

  constructor() { }

  sub!:Subscription

  ngOnInit(): void {

    this.sub = interval(1000).subscribe(n => console.log(n))

  }

  ngOnDestroy(): void {
    this.sub.unsubscribe()
  }

}

/**
 * Interval della libreria Rxjs
 *
 * Parte quando entro nella pagina interval
 * se esco dalla pagina continua
 * quando rientro nella pagina lui ne fa partire uno nuovo
 * Faccio dentro/fuori 10 volte e esplode tutto
 *
 * Per evitare faccio l'unsubscribe sull ngOnDestroy
 * quindi esattamente quando esco dalla pagina
 */
