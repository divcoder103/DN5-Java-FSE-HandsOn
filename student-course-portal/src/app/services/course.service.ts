import { Injectable } from '@angular/core';
import { Course } from '../course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  getCourses(): Course[] {
    return [
      new Course(101, 'Angular', 'Cognizant', '30 Hours'),
      new Course(102, 'Java', 'Oracle', '40 Hours'),
      new Course(103, 'Spring Boot', 'Pivotal', '35 Hours'),
      new Course(104, 'SQL', 'Oracle', '20 Hours')
    ];
  }

}
