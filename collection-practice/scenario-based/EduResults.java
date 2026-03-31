package scenario_based;

class Student {
    int rollNo;
    String name;
    int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " : " + marks;
    }
}

class MergeSort {
    public static void mergeSort(Student[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(Student[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];
        for(int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2) {
            if(L[i].marks >= R[j].marks) {   
                arr[k++] = L[i++];
            }else {
                arr[k++] = R[j++];
            }
        }
        while(i < n1) {
        	arr[k++] = L[i++];
        }
        while(j < n2) {
        	arr[k++] = R[j++];
        }
    }
}

public class EduResults {
	public static void main(String[] args) {
        Student[] district1 = {
            new Student(101, "Amit", 92),
            new Student(102, "Neha", 88)
        };
        Student[] district2 = {
            new Student(201, "Ravi", 95),
            new Student(202, "Priya", 90)
        };
        Student[] allStudents = new Student[
                district1.length + district2.length
        ];
        int index = 0;
        for(Student s : district1) {
        	allStudents[index++] = s;
        }
        for(Student s : district2) {
        	allStudents[index++] = s;
        }
        MergeSort.mergeSort(allStudents, 0, allStudents.length - 1);
        System.out.println("State Rank List:");
        int rank = 1;
        for(Student s : allStudents) {
            System.out.println("Rank " + rank++ + " -> " + s);
        }
    }
}
