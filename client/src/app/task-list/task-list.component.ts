import { TaskService } from './../services/task.service';

import { Component, OnInit } from '@angular/core';
import { Task } from '../entities/Task';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  protected _tasks: Task[];

  constructor(private taskService: TaskService) {}

  ngOnInit() {
    this.taskService.tasks.subscribe(updatedTasks => {
      this._tasks = updatedTasks;
    });
    this.taskService.getAllTasks();
  }

  protected deleteTask(id: number) {
    this.taskService.deleteTask(id);
  }
  protected swapTaskState(task: Task) {
    task.done = !task.done;
    this.taskService.editTask(task);
  }
}
