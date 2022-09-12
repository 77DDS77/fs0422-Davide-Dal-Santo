import { Component, OnInit } from '@angular/core';
import { filter, map, Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-interval2',
  templateUrl: './interval2.component.html',
  styleUrls: ['./interval2.component.scss']
})
export class Interval2Component implements OnInit {

  constructor() { }

  sub!:Subscription;

  ngOnInit(): void {

    function customInterval(time:number){

      return new Observable(observable => {
        let count = 0;

        setInterval(() => {
          observable.next(count);
          count++;
          if(count > 10){
            observable.error('Numero troppo grande')//unsubscribe automatico
          }
          if(count == 10 ){
            observable.complete();//unsubscribe automatic
          }
        }, time)


      })
    }

    this.sub = customInterval(1000)
    .pipe(
      filter(n => (<number> n) > 2 ), //se il numero e' magiore di 5 passalo al map
      map((n) => `Siamo al numero ${n}`)
    )
    .subscribe(
      {
        next: n => console.log(n),
        error: error => console.log(error),
        complete: () => console.log('completato')

      }

      /**
       * sintassi che useremo di piu
       * customInterval(1000).subscribe(res => /operazioni )
      */

      //sintassi deprecata
      //(n) => console.log(n),
      //error => console.log(error)
      );



  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

}

/**
 * il metodo next e' cio che invia il dato al subscribe
 * ogni volta che il metodo next viene lanciato un dato
 * viene inviato
 * E' cio che fa in modo ci sia uno stream di dati e non
 * un solo pacco di dati
 *
 * -
 *
 * A differenza delle promise gli observable soni pigri
 * vuol dire che per lanciarlo devo usare .subscribe()
 * se non lo uso il procvesso non parte
 *
 * -
 *
 * Il .pipe lo uso per modificare ogni dato prima che
 * venga inviato
 * NB: il map() che usiamo su sto pipe e' di Rxjs
 * non e' quello degli array
 *
 *
 */
