# TaskApp

A web Task Manager. 
This web application can help to manage the dependencies between tasks inside a co-working team.
A task can have many status: 
* _waiting_ : when the task is dependent to other tasks which are still not finished,
* _available_: when the task is available but still not assigned to any user,
* _in progress_: when the task is assigned to a user but still not finished,
* _done_: when the task is accomplished.

## Technologies used

* **java version** 1.7
* **Object DB** 2.6.9
* **JPA** 2.1.0
* **jsp** 2.1
* **Jetty** 6.1.10

## Install

Maven is used here as a build management tool.

## Running

The project can be imported in an IDE like Eclipse as a maven project and ran on server as a web-application.
