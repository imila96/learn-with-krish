import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee'
import { EmployeeService } from '../employee.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  _id: string;
  date:string;

  employees: Employee[];

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit(): void {
    this.employeeService.getEmployeesList().subscribe(data => {
      this.employees = data;
    });

  }

  // private getEmployees(){
  //   this.employeeService.getEmployeesList().subscribe(data => {
  //     this.employees = data;
  //   });
  // }

   Search(){

     this.employees=this.employees.filter(res=>{
      return res.date.match(this.date)
     });
   }
   Search2(){

    this.employees=this.employees.filter(res=>{
     return res._id.match(this._id)
    });
  }

  employeeDetails(_id: string){
    this.router.navigate(['employee-details', _id]);
  }

  updateEmployee(_id: string){
    this.router.navigate(['update-employee', _id]);
  }

  deleteEmployee(_id: string){
    this.employeeService.deleteEmployee(_id).subscribe( data => {
      console.log(data);
     // this.getEmployees();
    })
  }
}
