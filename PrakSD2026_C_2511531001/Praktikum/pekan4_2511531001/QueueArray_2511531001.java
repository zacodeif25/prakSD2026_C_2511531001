package pekan4_2511531001;

public class QueueArray_2511531001 {
	int front_1001, rear_1001, size_1001;
	int capacity_1001;
	int array_1001[];
	
	public QueueArray_2511531001 (int capacity_1001) {
		this.capacity_1001 = capacity_1001;
		rear_1001 = capacity_1001 -1;
		array_1001 = new int [this.capacity_1001 ];
		
	}
	
	boolean isFull_1001 (QueueArray_2511531001 queue_1001) {
		return (queue_1001.size_1001 == queue_1001.capacity_1001 );
	}
	
	boolean isEmpty_1001 (QueueArray_2511531001 queue_1001) {
		return (queue_1001.size_1001 ==0);
	}
	
	void enqueue_1001 (int item_1001) {
		if(isFull_1001(this))
			return;
		this.rear_1001 = (this.rear_1001 +1 ) % this.capacity_1001 ;
		this.array_1001 [this.rear_1001] = item_1001;
		this.size_1001 =this.size_1001 +1;
		System.out.println(item_1001 + " equeued to queue");
		}
	
	int dequeue_1001() {
		if (isEmpty_1001(this))
			return Integer.MIN_VALUE;
		int item_1001 = this.array_1001 [this.front_1001 ];
		this.front_1001 = (this.front_1001 +1 ) % this.capacity_1001 ;
		this.size_1001 = this.size_1001 -1;
		return item_1001;
	}
	
	int front_1001 () {
		if (isEmpty_1001(this))
			return Integer.MIN_VALUE ;
		return this.array_1001 [this.front_1001 ];
		}
	
	int rear_1001 () {
		if (isEmpty_1001(this))
			return Integer.MIN_VALUE ;
		return this.array_1001 [this.rear_1001 ];
		}
	
	//mencetak elemen antrian 
	
	void display_1001 () {
		int i ;
		if (front_1001 == rear_1001) {
			System.out.printf("\nAntrian Kosong\n");
			return;
		}
		
	//kunjungi dari belakang 
	
		for ( i = front_1001; i < rear_1001; i++) {
		System.out.printf(" %d <-- ", array_1001[i]);
	}
		return;
	}
	}
		
	
	
