var todos = [
    "clean room ",
    "Hair care ",
    "Clothing ",
    "Grocerries shopping"
];

var todosList = [
    "clean room ",
    "Hair care ",
    "Clothing ",
    "Grocerries shopping"
];

//add ! at the end of todos
/*
for(var i = 0; i < todos.length; i++)
{
    todos[i]= todos[i]+ "!";
    console.log(todos[i].concat("!"));

}*/
//remove todos list as we have finished the list
/*for(var i=0; i< todos.length; i++)
{
    todos.pop();
    console.log(todos);
    // ["clean room ", "Hair care ", "Clothing "]
     // ["clean room ", "Hair care "]
     //removed last 2 todos beacuse as todos.lenght will increase based on loop

}*/

//to remove all todos list
//assign todos.length to a variable thus making for loop condition to compare fixed length.
/*var todosLength = todos.length;
for(var i=0; i< todosLength; i++)
{
    todos.pop();
    console.log(todos);
    //output
    // ["clean room ", "Hair care ", "Clothing "]
//      ["clean room ", "Hair care "]
//      ["clean room "]
//      [] <- empty todos list
}*/

/*//Lets Learn While
var todosLength = todos.length;
var counterOne = 10;
while(counterOne > 0)
{
    console.log(counterOne);
    counterOne--;
}*/

/*
//Now  do-while Loop
var counterTwo = 10
do{
    console.log(counterTwo);
    counterTwo--;
}while(counterTwo>0);
*/


//For-Each Loop

var todosLength = todos.length;
/*for(var i=0; i< todosLength; i++)
{
    console.log(todos[i]);
}
todos.forEach(function(todo, i)
{
    console.log(todo,i);
}
)*/

function logTodos(todos,i){
    console.log(todos,i);
}
todos.forEach(logTodos);
todosList.forEach(logTodos);























