import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/Classes/user';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(
    private activeRoute: ActivatedRoute,
    private auth: AuthService
  ) { }

  user!: User;


  ngOnInit(): void {
    console.log(this.activeRoute.snapshot.paramMap)
    console.log(this.auth.getLoggedUser());
    this.user = this.auth.getLoggedUser()
  }

}
