var database = [
         {
            username:"Hari",
            password:"Hari"

         },
         {
                     username:"Sally",
                     password:"Sally"

           },
         {
                     username:"Mitch",
                     password:"Mitch"

          }

];

var newsFeed = [
{
    username:"Bob",
    timeline:"Tired"
    },
    {
        username:"Sally",
        timeline:"Cool"

        }
];
var usernamePrompt = prompt("username please");
var passwordPrompt = prompt("What's the secret");
var databaseLength = database.length;

function isUserValid(user, pwd)
{
    for(var i=0; i<databaseLength; i++)
        {
            if(database[i].username === user &&
            database[i].password === pwd)
            return true;
            }
         return false;

}
function signIn(username,password)
{
    //console.log(isUserValid(username,password));

    //Based Loops we learned

        if(isUserValid(username,password))
        console.log(newsFeed);
        else
        alert("Hey....wr s ur brain...that's wrong entries")


    //first time
    /*if(user === database[0].username && pwd == database[0].password)
    {
        console.log(newsFeed);
    }else alert("Hey...wrong creds");*/

}
signIn(usernamePrompt,passwordPrompt);