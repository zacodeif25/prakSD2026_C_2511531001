package pekan4_2511531001;

public class QueueArrayDriver_2511531001 {
	public static void main (String [] args) {
		QueueArray_2511531001 queue_1001 = new QueueArray_2511531001(1000);
		queue_1001.enqueue_1001(10);
		queue_1001.enqueue_1001(20);
		queue_1001.enqueue_1001(30);
		queue_1001.enqueue_1001(40);
		System.out.println("Item di depan " + queue_1001.front_1001() );
		System.out.println("Item paling belakang " + queue_1001.rear_1001());
		System.out.println("tampilan queue");
		queue_1001.display_1001();
		System.out.println();
		System.out.println(queue_1001.dequeue_1001() + " dihapus dari queue");
		System.out.println("Item di depan : " + queue_1001.front_1001() );
		System.out.println("Item paling belakang  : " + queue_1001.rear_1001());
		System.out.println("tampilan queue setelah satu data dihapus");
		queue_1001.display_1001();
	}
}
