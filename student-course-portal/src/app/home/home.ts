import { Component } from '@angular/core';
import { CourseComponent } from '../course/course';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CourseComponent],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {}
