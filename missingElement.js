let a = [121,120,124,123,125];
let len=a.length;
  
let b=a.sort();

let min=b[0];
let max=b[len-1]

    let answer=missingNo(a,b[0],len,min,max);
    console.log(answer);

function missingNo(elt,e1,length,min,max){

    let missingElt;

if(min!=e1){
    missingElt=e1;
}
else if(max!=e1+length){
    missingElt=e1+length;
}
else{
    for(let i=min;i<=max;i++){
       
        if(elt.indexOf(i)<0){
           missingElt=i; 
        }
    } 
}

    return missingElt;
}
