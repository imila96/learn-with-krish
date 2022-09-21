import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:3000/products";

  constructor(private httpClient: HttpClient) { }
  
  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  getEmployeeById(_id: string): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${_id}`);
  }

  updateEmployee(_id: string, employee: Employee): Observable<Object>{
    return this.httpClient.patch(`${this.baseURL}/${_id}`, employee);
  }

  deleteEmployee(_id: string): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${_id}`);
  }
}
