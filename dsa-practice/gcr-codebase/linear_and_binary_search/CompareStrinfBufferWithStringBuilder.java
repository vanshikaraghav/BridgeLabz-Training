package linear_and_binary_search;

public class CompareStrinfBufferWithStringBuilder {
    public static void main(String[] args) {
        int iterations = 1000000;
        long startTime1 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<iterations;i++) {
            sbf.append("hello");
        }
        long endTime1 = System.nanoTime();
        long bufferTime = endTime1 - startTime1;
        long startTime2 = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for(int i=0;i<iterations;i++) {
            sbd.append("hello");
        }
        long endTime2 = System.nanoTime();
        long builderTime = endTime2 - startTime2;
        System.out.println("Time taken by StringBuffer: "+bufferTime+" ns");
        System.out.println("Time taken by StringBuilder: "+builderTime+" ns");
    }
}