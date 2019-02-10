export class Task {
  id: number;
  title = '';
  done = false;

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
