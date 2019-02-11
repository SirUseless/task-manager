import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Task } from '../entities/Task';
import { TaskService } from './../services/task.service';

@Component({
  selector: 'app-task-add',
  templateUrl: './task-add.component.html',
  styleUrls: ['./task-add.component.scss']
})
export class TaskAddComponent implements OnInit {
  protected title = '';
  protected unique = true;
  taskFormControl = new FormControl('', [Validators.required]);

  constructor(private taskService: TaskService) {}

  ngOnInit() {}

  protected addTask() {
    if (this.title.length > 0 && this.unique) {
      const task: Task = new Task();
      task.done = false;
      task.title = this.title;
      this.title = ''; // clear add imput

      this.taskService.addTask(task);
    }
  }

  protected validateTitle() {
    this.unique = true;
    this.taskService.tasks.forEach(taskList =>
      taskList.forEach(task => {
        if (task.title === this.title) {
          this.unique = false;
        }
      })
    );
  }
}
