import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';
import { Course } from '../course.model';

@Component({
  selector: 'app-course',
  standalone: true,
  imports: [],
  templateUrl: './course.html',
  styleUrl: './course.css'
})
export class CourseComponent implements OnInit {

  courses: Course[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.apiService.getCourses().subscribe({
      next: (data) => {
        this.courses = data;
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
  deleteCourse(id: number) {

  this.apiService.deleteCourse(id).subscribe(() => {

    this.courses = this.courses.filter(c => c.id !== id);

  });

}

}
