import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UrlSerializer } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'creditapp-web';


  public user=new ServiceRequest();

  form = new FormGroup({
   tcNo:new FormControl('',[
      Validators.required,
      Validators.minLength(11),
      Validators.maxLength(11)
    ]),
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    maas: new FormControl('', [
   
   
    ]),
    
    telNo:new FormControl('',[
      Validators.required, Validators.pattern("[0-9 ]{12}")
    ]),
    
   });
    constructor(private service:HttpClient,private toastr: ToastrService) { }
     get tcno(){
      return this.form.get('tcNo')
     }
    get firstname(){
      return this.form.get('firstName')
    }
    get lastname(){
      return this.form.get('lastName')
    }
    get telno(){
      return this.form.get('telNo')
    }

    get maas(){
      return this.form.get('maas')
    }


    ngOnInit() {
    }
    showToaster(){
      this.toastr.success("Kredi Başvurunuz Onaylanmıştır.                                          ")
  }
    onSubmit(){
    
   
     this. user.username=this.form.controls["firstName"].value;
     this.  user.lastname=this.form.controls["lastName"].value;
     this.  user.salary=this.form.controls["maas"].value;
     this.  user.tcno=this.form.controls["tcNo"].value;
     this.   user.tel=this.form.controls["telNo"].value;

            
     this.service.post( "http://localhost:8081/api/credit/score", this.user, {
      observe: 'body'
    }).subscribe((model: any) => {

      if (model) {
        if(model.status=='APPROVED'){

       
          this.toastr.success("Kredi Başvurunuz Onaylanmıştır. Krediniz:  "+model.credit+" TL"); 
      }
      else{
        this.toastr.error("Kredi Başvurunuz Red edilmiştir");
      }
        
        
      }
      
    }, error => {
      console.log(error)
    
    });

    }

}
export class ServiceRequest {
  public tcno: string;
  public username: string;
  public  lastname:string;
   public salary:number;
   public tel:string;
 
 }
 
