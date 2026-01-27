package queue_interface;

public class CircularBufferSimulation {
	
	static class CircularBuffer {
        int[] buffer;
        int size, front = 0, count = 0;

        CircularBuffer(int size) {
            this.size = size;
            buffer = new int[size];
        }

        void insert(int value) {
            buffer[(front + count) % size] = value;
            if(count < size) {
                count++;
            }else {
                front = (front + 1) % size; 
            }
        }

        void display() {
            for(int i=0;i<count;i++) {
                System.out.print(buffer[(front + i) % size] + " ");
            }
            System.out.println();
        }
	}
	
	public static void main() {
		CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.insert(4);
        System.out.print("Circular Buffer: ");
        buffer.display();
	}
        
}
