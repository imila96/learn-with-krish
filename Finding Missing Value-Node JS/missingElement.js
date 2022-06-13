let a = [21,25,29,28,22,24,27,26,30];
let len=a.length;
 //sort array
let b=a.sort();

let min=b[0];
let max=b[len-1]

    let answer=missingNo(b,b[0],len,min,max);//calling the function
    console.log(answer);

function missingNo(elt,e1,length,min,max){

//checking whether the elements sorted array are sequential or not.
let arr = a;
let differenceAry = arr.slice(1).map(function(n, i) { return n - arr[i]; })
let isDifference= differenceAry.every(value => value == 1)

console.log(isDifference);

//if not sequential
if(isDifference==false){
	let sum = 0;

for (let i = 0; i < elt.length; i++) {
    sum += elt[i];
}

let totalSum = Math.floor((max - min + 1) * (min + max) / 2);

let missingElt=totalSum-sum;

    return "The values in array are not sequential.So missing value is "+missingElt;
	
	
	
}else{
	//if sequential
	let startNo=min-1;
	let endNo=max+1;
	 return "The values in array are  sequential.So missing values could be either startNo :"+startNo+" or either end No :"+endNo;
}

	
}
  