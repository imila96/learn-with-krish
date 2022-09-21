import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
   
orderId:string;
  employee: Employee = new Employee();
  
  x: string;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data.toString());
      
      splitJson(data);

     //alert( JSON.stringify(data));
    },
    error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
  
  
  onSubmit(){
    console.log(this.employee);
   
    this.saveEmployee();
   // this.showStatus();
  }

  employeeDetails(id: String){
    this.router.navigate(['employee-details', id]);
  }

  //  showStatus(){

  //    alert(this.x);
  //  }

  
  
}
function splitJson(data: Object) {
  
let str: string =JSON.stringify(data);
  
let arr: Array<string> = str.split(",");
  let s1=arr[0];
  let s2=arr[3].substring(10,(arr[3].length-1));

  if(s2=="reserved"){
  alert("Order Id : "+"  "+s1.substring(21,(s1.length-1))+"\n Status : "+arr[3].substring(10,(arr[3].length-1))+"\n Dispatch Date : "+arr[6].substring(8,(arr[6].length-2)));
  }
  else{
    alert("order not placed due to limited stock");
  }

  
}

