import { Component, OnInit } from '@angular/core';
import { Task } from '../entities/Task';
import { TaskService } from './../services/task.service';

@Component({
  selector: 'app-task-add',
  templateUrl: './task-add.component.html',
  styleUrls: ['./task-add.component.scss']
})
export class TaskAddComponent implements OnInit {
  protected title: string;

  constructor(private taskService: TaskService) {}

  ngOnInit() {}

  protected addTask() {
    const task: Task = new Task();
    task.done = false;
    task.title = this.title;
    this.title = ''; // clear add imput

    this.taskService.addTask(task);
  }
}
