import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-enroll',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './enroll.html',
  styleUrl: './enroll.css'
})
export class Enroll {

  studentName = '';
  courseName = '';

  submit() {
    alert(
      `Student: ${this.studentName}\nCourse: ${this.courseName}`
    );
  }

}
