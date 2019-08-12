var age = prompt("How Old are you ?");

function checkDriveAge()
{
console.log(age);
if (Number(age) < 18)
{
    alert("Hey...grow up and come back later");
}
else if(Number(age) > 18)
{
		alert("Ride is here......You are set to GO...");
}else alert("Enjoy your First Drive....!!!!!!!!");

}
function checkDriveAge1(age)
{
console.log(age);
if (Number(age) < 18)
{
    alert("Hey...grow up and come back later");
}
else if(Number(age) > 18)
{
		alert("Ride is here......You are set to GO...");
}else alert("Enjoy your First Drive....!!!!!!!!");

}
checkDriveAge();
checkDriveAge1(98);




