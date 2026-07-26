import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from '../course.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:3000/courses';

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl);
  }
  addCourse(course: Course) {
  return this.http.post<Course>(this.apiUrl, course);
}

updateCourse(course: Course) {
  return this.http.put<Course>(`${this.apiUrl}/${course.id}`, course);
}

deleteCourse(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
}

}
