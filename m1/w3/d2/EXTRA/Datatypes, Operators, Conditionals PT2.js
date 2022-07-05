// Additional assignments for Day 3

/*EX 1
 Use a ternary operator to assign to a variable called gender the string values "male" or "female".
 The choice should be made based on the value of another variable called isMale.
*/


/* WRITE YOUR ANSWER HERE */
console.log('EX 1')

let isMale = 'female';

let gender = (isMale == 'male' ? "male" : "female"); //return (operator ? truthy : falsy)
console.log('Person is :' + gender);


/*EX 2
 Write a piece of code for checking if, given two integers, the value of one of them is 8 or if their addition or subtraction is equal to 8.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 2')

let num1 = 130;
let num2 = 9;

if(num1 == 8 || num2 == 8){
    console.log('one of the given number equals to 8');
}else if((num1 + num2) == 8){
    console.log('num1 + num2 equals to 8');
}else if((num1 - num2) == 8){
    console.log('num1 - num2 equals to 8');
}else{
    console.log('given numbers mean nothing to this script');
}

/*EX 3
 Create a variable and assign to it the concatenation of two strings.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 3')

let hi = 'Hi ';
let name = 'my name is SLIM SHADY';
let phrase = hi + name;

console.log(phrase);

/*EX 4
 Create three variables and assign a numerical value to each one of them. 
 Using a conditional statement, write a piece of code for sorting their values from highest to lowest.
 Display the result in the console.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 4')

let number1 = 8;
let number2 = 7;
let number3 = 10;

if (number1 > number2 && number1 > number3){
    if(number2 > number3){
        console.log(number1 + ' ' + number2 + ' ' + number3);
    }else{
        console.log(number1 + ' ' + number3 + ' ' + number2);
    }
}else if(number2 > number1 && number2 > number3){
    if(number1>number3){
        console.log(number2 + ' ' + number1 + ' ' + number3);
    }else{
        console.log(number2 + ' ' + number3 + ' ' + number1);
    }
}else{
    if(number1 > number2){
        console.log(number3 + ' ' + number1 + ' ' + number2);
    }else{
        console.log(number3 + ' ' + number2 + ' ' + number1);
    }
}

/*EX 5
 Write a piece of code for finding the average of two given integers.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 5')

let int1 = 20;
let int2 = 0;

console.log('Average between ' + int1 + ' and ' + int2 + ' equals to: ' +(int1 + int2)/2);

/*EX 6
 Write a piece of code for finding the longest of two given strings.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 6')

let str1 = 'hello my name is Davide';
let str2 = 'but my friends call me DDS';

if(str1.length > str2.length){
    console.log(str1 + ' is the longest with ' + str1.length + ' characters');
}else{
    console.log(str2 + ' is the longest with ' + str2.length + ' characters');
}

/*EX 7
 Write a piece of code for checking if a given value is a integer or not.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 7')

let intTest = 7.7;
let intTest2 = 7;

console.log('Is given number integer? ' + Number.isInteger(intTest));
console.log('Is given number integer? ' + Number.isInteger(intTest2));

/*EX 8
 Write a piece of code for calculating a certain percentage of a given number.
 (Ex.: the 20% of 400 is 80)
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 8')

let numX = 100;
let numY = 25;

console.log(numY + '% of ' + numX + ' is ' + ((numX/100)*numY));

/*EX 9
 Write a piece of code for checking if a given number is even or odd.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EX 9')

let oddEven = 38;

if(Number.isInteger(oddEven/2)){
    console.log(oddEven + ' is an even number');
}else{
    console.log(oddEven +' is an odd number');

}
