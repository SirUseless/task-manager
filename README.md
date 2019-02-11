# task-manager

![Java Spring-Boot + Angular7 Reactive
](https://cdn-images-1.medium.com/max/1200/1*rXKU7dQO6joxBsYfktv4mQ.png)

Java Spring-Boot + Angular7 Reactive

## How to try

A deployed dist is provided in the backend Spring server, so running the Spring-Boot app
and opening [http://localhost:8080/](http://localhost:8080/) will show the working app.

## Dependencies

In order to test Angular's source, [NodeJS](https://nodejs.org/en/) environment is required.
In order to install the dependencies, run `npm install` onthe `/client` folder.

## Building the Angular project

Running `npm build --prod` on the `/client` folder will create a `/dist` directory.
Moving the contents of the `/dist/taskmanager-front` directory to `/server/src/main/resources/public` will cause spring boot to serve the angular app as static files.
