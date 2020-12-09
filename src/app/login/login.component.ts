import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Route, Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userdetails = {
                  uname:"",
                  password:""
                };

  constructor(private service:AuthService,
     private router:Router) 
  {

  }
  message;
  SignIn()
  {
    let isvalid = this.service.Login(this.userdetails);
    if(isvalid)
    {
      this.router.navigate(['home']);
    }
    else{
      this.message = "Uname/Pass is incorrect";
    }
  }

  ngOnInit() {
  }

}
