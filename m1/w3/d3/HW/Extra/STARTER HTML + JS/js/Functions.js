/*
ASSIGNMENT RULES
- All the answers must be written in JavaScript
- You can ask for help, reach the Teaching Assistants if needed
- You can Google / use StackOverflow BUT only when you think you need something we didn't cover during lessons yet
- You can test your code in a separate file or de-commenting the single exercises in this one.
- You can use the bash terminal, the VSCode terminal or the one embedded in your Operating System if you're using macOS or Linux.
- The solution must be pushed to the repository and be available for the tutors by the end of the day (5PM CET)
*/

/* EXERCISE 1
 Write a function called "area" which receives 2 parameters (l1, l2) and calculates the area of the associated rectangle.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EXERCISE 1');

function area(l1, l2){
    let area = l1 * l2;
    return area;
}
console.log('Your area is: ' + area(15, 10));

/* EXERCISE 2
 Write a function called "crazySum" which receives two integers as parameters.
 It should return the sum of those two values, but if the two values are the same then it should return their sum multiplied by 3.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EXERCISE 2');

function crazySum(n1, n2){
    if(n1 === n2){
        let sum = (n1 + n2) * 3;
        return sum;
    }else{
        sum = (n1 + n2);
        return sum;
    }
}

console.log('Crazysum: ' + crazySum(3, 3));

console.log('Sum: ' + crazySum(3, 4));

/* EXERCISE 3
 Write a function called "crazyDiff" that computes the absolute difference between a given number and 19.
 It should return triple their absolute difference if the given number is greater than 19.
*/

/* WRITE YOUR ANSWER HERE */

console.log('EXERCISE 3');

function crazyDiff(n3){
    if(n3 > 19){
        let diff = Math.abs(n3 - 19) * 3;
        return diff;
    }else{
        diff = Math.abs(n3 - 19);
        return diff;
    }
}

console.log('CrazyDiff; ' + crazyDiff(20));
console.log('Diff: ' + crazyDiff(-9));

/* EXERCISE 4
 Write a function called "boundary" which accept an integer parameter n and returns true if n is within 20 and 100 (included) or if n it's equal to 400.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EXERCISE 4');

function boundary(n){
    if(n >= 20 && n <= 100 || n === 400){
        return true + '  n: ' + n;
    }else{
        return false+ '  n: ' + n;
    }
}

console.log('Insert number is with boundary restrictions: ' + boundary(30));
console.log('Insert number is with boundary restrictions: ' + boundary(130));
console.log('Insert number is with boundary restrictions: ' + boundary(400));

/* EXERCISE 5
 Write a function called "strivify" which accepts a string as a parameter.
 It should add the word "Strive" in front of the given string, but if the given string already begins with "Strive", then it should just return the original string.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EXERCISE 5');

const SUBSTR = 'Strive';

function strivify(str){
    if(str.toLowerCase().startsWith(SUBSTR.toLowerCase())){
        return str;
    }else{
        return SUBSTR + ' ' + str;
    }
}

console.log(strivify('strive for the better'));
console.log(strivify('deez nuts'));





/* EXERCISE 6
 Write a function called "check3and7" which accepts a positive number as a parameter and checks if it is a multiple of 3 or a multiple of 7.
 HINT: Modulus Operator
*/

/* WRITE YOUR ANSWER HERE */
console.log('EXERCISE 6');

let n = -14;

function check3and7(n) {
    if (n >= 0) {
        if ((n % 3) === 0) {
            return n + ' is a multiple of 3';
        } else if ((n % 7) === 0) {
            return n + ' is a multiple of 7';
        } else {
            return n + ' is not a multiple of neider 3 or 7';
        }
    }else{
        return 'Must insert positive number';
    }
}
console.log(check3and7(1667325459));
console.log(check3and7(479962));
console.log(check3and7(4));
console.log(check3and7(-4));


/* EXERCISE 7
 Write a function called "reverseString" which programmatically reverses a given string (es.: Strive => evirtS).
*/

/* WRITE YOUR ANSWER HERE */
console.log('EXERCISE 7');

function reverseString(str){
    var arrStr = str.split('');
    var reverseArr = arrStr.reverse();
    var strRev = reverseArr.join('');
    return strRev;   
}
console.log(reverseString('i topi non avevano nipoti'));

function reverseStringFast(str){
    return str.split('').reverse().join('');
}
console.log(reverseStringFast('e dio lo gnomo mongolide'));

/* EXERCISE 8
 Write a function called "upperFirst" which capitalizes the first letter of each word of a given string passed as a parameter.
*/

/* WRITE YOUR ANSWER HERE */
console.log('EXERCISE 8');

let i = 0;
function upperFirst(str){
    while ( i <= str.split().length){
        if(str.split().length[i - 1] === ' '){
            str.split().length[i].toUpperCase;
        }
        i++;
    }
}

let stringa = 'appelle figlia di apollo';
console.log(stringa.split('').length[2]);

console.log(upperFirst(' ciao io mi chiamo davide'));

/* EXERCISE 9
 Write a function called "cutString" which creates a new string without the first and last character of a given string passed as a parameter.
*/

/* WRITE YOUR ANSWER HERE */

/* EXERCISE 10
 Write a function called "giveMeRandom" which accepts a number n and returns an array containing n random numbers between 0 and 10.
*/

/* WRITE YOUR ANSWER HERE */

/* WHEN YOU ARE FINISHED
 Commit and push the code to your personal GitHub repository; then post the link of your commit on the Homework section of today's Eduflow.
*/
