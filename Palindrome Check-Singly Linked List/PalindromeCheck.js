class Node {
  constructor(data, next = null) {
    this.data = data;
    this.next = next;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.size = 0;
  }


  insertFirst(data) {
    this.head = new Node(data, this.head);
    this.size++;
  }


  printListData() {
    let current = this.head;

    while (current) {
      console.log(current.data);
      current = current.next;
    }
  }



convertArr()
{
 
    
    var temp = this.head;
    var len = 0;
    while (temp != null)
    {
        len++;
        temp = temp.next;
    }
 
    
    let arr = new Array(len);
     
    let index = 0;
    var curr = this.head;
 
    
    while (curr != null)
    {
        arr[index++] = curr.data;
        curr = curr.next;
    }
 
 
  
  
		let flag = 0;
 
       
        for (let i = 0; i <= len / 2 && len != 0; i++) {
 
    
            if (arr[i] != arr[len - i - 1]) {
                flag = 1;
                break;
            }
        }
 
        
        if (flag == 1)
            console.log("This linked list is Not Palindrome");
        else
            console.log("This linked list is Palindrome");
    }
  

}


const ll = new LinkedList();

ll.insertFirst(100);
ll.insertFirst(200);
ll.insertFirst(300);
ll.insertFirst(200);
ll.insertFirst(100);


ll.printListData();
ll.convertArr();


let palindromeArray = (arr) => {
     
     let isPalindrome = true;
     
    
     for(let i = 0; i < arr.length / 2; i++) {

        
         if(arr[i] !== arr[arr.length - i - 1]){
           isPalindrome = false; 
           break;
         }
     }
     
     return isPalindrome;
}