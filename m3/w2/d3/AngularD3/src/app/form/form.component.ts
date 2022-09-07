import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { User } from '../Models/user';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  @Output() onNewUserCreated = new EventEmitter<User>();

  constructor() { }

  ngOnInit(): void {
  }

  newUser:User = new User('', '');

  sendDataToParent(){
    this.onNewUserCreated.emit(this.newUser);
    this.newUser = new User('', '');
  }
}

/**
 * EventEmitter
 *
 * Mi serve per mandare dati dal figlio al parent
 * Da figlio a parent posso inviare dati solo attraverso
 * un metodo
 *
 * Importando EventEmitter sblocco il metodo .emit da usare dentro
 * al metodo, nelle parentesi di .emit() metto il dato da inviare
 *
 * sull'HTML del parent dove richiamo il componente child
 * scrivo
 * <app-form (onNewUserCreated)="addUser($event)"></app-form>
 *
 * (onNewUserCreated)="" e' l'evento
 * dentro le virgolette devo avere un metodo pronto a gestire
 * il dato che invio dal child, e nei parametri del metodo
 * lo richiamero' con "$event"
 *
 * Event Emitter permette la tipizzazione con generics
 */
