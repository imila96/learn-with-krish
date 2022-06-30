class Node {
		constructor(data) {
		this.data = data;
		this.next = null;
	}
}


const a = new Node(1);
const b = new Node(2);
const c = new Node(3);
const d = new Node(4);

	a.next=b;
	b.next=c;
	c.next=d;

const print = (head) => {
	
	if (head == null) return;
	console.log(head.data);
	print(head.next);
	
};

print(a);

const reverseList = (head) =>{
	
	let prev = null;
	let curr = head;
	
	while(curr !== null){
		const next = curr.next;
		curr.next = prev; 
		
		prev = curr;
		curr = next;
		
	}
	return prev;
};
const newHead = reverseList(a);
console.log('after reversing the list');
print(newHead);

