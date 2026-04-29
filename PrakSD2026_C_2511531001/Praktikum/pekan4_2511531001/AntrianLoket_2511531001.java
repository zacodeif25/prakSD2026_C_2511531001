package pekan4_2511531001;

public class AntrianLoket_2511531001 {
	// Variabel sesuai ketentuan tugas + suffix _1001
	String[] queue_1001;
	int front_1001;
	int rear_1001;
	int max_1001;
	int count_1001; // Variabel bantu untuk melacak jumlah elemen aktif

	// Konstruktor inisialisasi array & indeks
	public AntrianLoket_2511531001(int max_1001) {
		this.max_1001 = max_1001;
		this.queue_1001 = new String[this.max_1001];
		this.front_1001 = 0;
		this.rear_1001 = -1;
		this.count_1001 = 0;
	}

	// 1. isEmpty(): Cek apakah antrian kosong
	public boolean isEmpty_1001() {
		return count_1001 == 0;
	}

	// 2. isFull(): Cek apakah antrian penuh
	public boolean isFull_1001() {
		return count_1001 == max_1001;
	}

	// 3. enqueue(): Tambah data ke belakang antrian
	public void enqueue_1001(String nama_1001) {
		if (isFull_1001()) {
			System.out.println("Antrian sudah penuh!");
			return;
		}
		// Circular queue logic
		rear_1001 = (rear_1001 + 1) % max_1001;
		queue_1001[rear_1001] = nama_1001;
		count_1001++;
		System.out.println("Data berhasil ditambahkan ke antrian");
	}

	// 4. dequeue(): Hapus data dari depan antrian
	public void dequeue_1001() {
		if (isEmpty_1001()) {
			System.out.println("Antrian kosong!");
			return;
		}
		String nama_1001 = queue_1001[front_1001];
		front_1001 = (front_1001 + 1) % max_1001;
		count_1001--;
		System.out.println(nama_1001 + " telah dilayani");
	}

	// 5. display(): Tampilkan seluruh isi antrian
	public void display_1001() {
		if (isEmpty_1001()) {
			System.out.println("Isi antrian: Kosong");
			return;
		}
		System.out.println("Isi antrian:");
		for (int i_1001 = 0; i_1001 < count_1001; i_1001++) {
			int idx_1001 = (front_1001 + i_1001) % max_1001;
			System.out.println((i_1001 + 1) + ". " + queue_1001[idx_1001]);
		}
	}

	// 6. reverse(): Balik urutan seluruh isi antrian
	public void reverse_1001() {
		if (isEmpty_1001()) {
			System.out.println("Antrian kosong, tidak dapat dibalik.");
			return;
		}
		String[] temp_1001 = new String[max_1001];
		int idx_1001 = front_1001;
		
		// Salin elemen ke array sementara
		for (int i_1001 = 0; i_1001 < count_1001; i_1001++) {
			temp_1001[i_1001] = queue_1001[idx_1001];
			idx_1001 = (idx_1001 + 1) % max_1001;
		}
		
		// Balik urutan di array sementara
		for (int i_1001 = 0; i_1001 < count_1001 / 2; i_1001++) {
			String swap_1001 = temp_1001[i_1001];
			temp_1001[i_1001] = temp_1001[count_1001 - 1 - i_1001];
			temp_1001[count_1001 - 1 - i_1001] = swap_1001;
		}
		
		// Kembalikan ke queue utama & reset indeks ke bentuk linier
		front_1001 = 0;
		rear_1001 = count_1001 - 1;
		for (int i_1001 = 0; i_1001 < count_1001; i_1001++) {
			queue_1001[i_1001] = temp_1001[i_1001];
		}
	}
}
