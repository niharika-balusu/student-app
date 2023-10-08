# student-app
Student Appliction

Student Controller API
This API provides endpoints to manage student resources.

Endpoints
Get All Students
Request
GET /api/v1/students
Response
Returns a list of all students.
[
    {
        "id": 1,
        "firstname": "Niharika",
        "lastname": "balusu",
        "age": 30
    }
    // ...
]

Get Student by ID
Request
GET /api/v1/students/{id}
{
     "id": 1,
     "firstname": "Niharika",
     "lastname": "balusu",
     "age": 30
}

Create Student
Request
POST /api/v1/students
Creates a new student. Provide student details in the request body.

Example Request Body:
{
    "firstname": "Niharika",
    "lastname": "balusu",
    "age": 30
}
Response
Returns the created student.
{
     "id": 1,
     "firstname": "Niharika",
     "lastname": "balusu",
     "age": 30
}
Update Student
Request
PUT /api/v1/students/{id}
Updates an existing student identified by ID. Provide updated student details in the request body.

Example Request Body:
{
    "firstname": "Niharika",
    "lastname": "balusu",
    "age": 32
}
Response
Returns the updated student.
{
     "id": 1,
     "firstname": "Niharika",
     "lastname": "balusu",
     "age": 32
}
Delete Student
Request
DELETE /api/v1/students/{id}
Deletes the student identified by ID.

Response
No content. The student is deleted successfully.


