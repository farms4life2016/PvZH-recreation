function play() {
	
	//semicolon at end of statements like java
	//this is a comment xD  -- like java too!
	
  document.getElementById("text").innerHTML = "start playing game..."; //changes "text" paragraph to the string
  document.getElementById("number").innerHTML = 9+10; //changes "number" paragraph to the value of 19. (automatic cast to string)
  //alert("The zombies are coming..."); //creates a dialogue box with specified string 
  console.log("debug message"); //send a message to console (inspect element)
  //print(); //will physically print out the page, js has no "print" function 
  
  //declaring variables 
  var a; //initialize variables 
  let y; //according to Leon, don't use "var" keyword unless you want the variable to be visible throughout the entire function instead of the if block or loop block 
  
  //integers and decimals are grouped together, no need for casting
  //collectively known as "number" 
  var x = 1; //can also directly assign values to variables 
  x = x + 0.5;
  console.log(typeof 0); 
  console.log(x);
  console.log(5/2); //smart division, outputs 2.5 unlike java's truncation
  
  //strings can be in single or double quotes like python 3
  let str = "brain" + 'zzzzzzzzzzzz';
  console.log(str);
  
  //constants declared using const 
  const pi = 3.141; //by the way you should ALWAYS declare a variable as const if that variable will  
					//never change (note: you can still change array elements or object properties)
  
  //declare multiple variables in one statement 
  let k1 = 0, k2= 1e-3, k3 = 3;
  k3 = "String"; //can also change k3 to a string variable and vice versa
  
  //null in java --> undefined in js
  let str2 = undefined;
  //cannot redeclare "let" variables just like java 
  
  //by the way $ is considered a letter lmao
  let $lmao$ = 2;
  let __init__ = 3; //starting variables with _ is allowed
  
  console.log(2**3) // like python 3, a**b in js = a^b in math 
  //most other operators from java and python are also in js (e.g. ++, +=, %, ...)
  console.log(2 + "3") //adding number to string will autocast the number to a string
  console.log(2 + 4 + "3") //prints 63 cuz left to right evaluation 
  
  //arrays, declared just like java 
  const zombies = ["cone", "bucket", "screen door"];
  console.log(zombies[0]);
  zombies.push("nein"); //add element 
  console.log(zombies[3]);
  
  //objects (wtf?)
  const zombie = {hp:"100", speed:"1.0", butter_timer:"0"};
  zombie.speed = "1.2"; //change properties
  zombie.speech = "brains"; //add properties 
  
}
