import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  constructor(
    private auth: AuthService,
    private router: Router
    ) { }

  userName!: string

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    if(this.checkIfUserLogged()){
      this.userName = this.getUserName();
    }
  }

  isMenuCollapsed = true;

  checkIfUserLogged():boolean{
    return this.auth.isUserLogged();
  }

  getUserName():string{
    return this.auth.getLoggedUser().name;
  }

  logOut():void{
    this.auth.logOut()
    this.router.navigate(['/'])
  }

}
