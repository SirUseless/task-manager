import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Task } from '../entities/Task';

const API_URL = environment.api_url;
const TASK_URL = '/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks: Observable<Task[]>;
  private _tasks: BehaviorSubject<Task[]>;
  private dataStore: {
    tasks: Task[];
  };

  constructor(private http: HttpClient) {
    this._tasks = <BehaviorSubject<Task[]>>new BehaviorSubject([]);
    this.dataStore = { tasks: [] };
    this.tasks = this._tasks.asObservable(); // same as get tasks() { return this._tasks.asObservable()}
  }

  public getAllTasks() {
    this.http
      .get<Task[]>(API_URL + TASK_URL)
      .pipe(catchError(this.errorHandler))
      .subscribe(updatedTasks => {
        this.dataStore.tasks = updatedTasks;
        this._tasks.next(Object.assign({}, this.dataStore).tasks);
      });
  }

  // not needed for this functionality
  /*public getOneTask(taskId: number) {
    this.http
      .get<Task>(API_URL + TASK_URL + '/' + taskId.toString())
      .pipe(catchError(this.errorHandler));
  }*/

  public addTask(task: Task) {
    this.http
      .post<Task>(API_URL + TASK_URL, task)
      .pipe(catchError(this.errorHandler))
      .subscribe(data => {
        this.dataStore.tasks.push(data);
        this._tasks.next(Object.assign({}, this.dataStore).tasks);
      });
  }

  public editTask(task: Task) {
    this.http
      .put(API_URL + TASK_URL + '/' + task.id.toString(), task)
      .pipe(catchError(this.errorHandler))
      .subscribe(data => {
        this.dataStore.tasks.forEach((t, i) => {
          if (t.id === task.id) {
            this.dataStore.tasks[i] = task;
          }
        });
        this._tasks.next(Object.assign({}, this.dataStore).tasks);
      });
  }

  public deleteTask(id: number) {
    this.http
      .delete(API_URL + TASK_URL + '/' + id.toString())
      .pipe(catchError(this.errorHandler))
      .subscribe(res => {
        this.dataStore.tasks.forEach((t, i) => {
          if (t.id === id) {
            this.dataStore.tasks.splice(i, 1);
          }
        });
        this._tasks.next(Object.assign({}, this.dataStore).tasks);
      });
  }

  private errorHandler(error: HttpErrorResponse) {
    console.log(error.message);
    return throwError(error.message || 'Server Error');
  }
}
