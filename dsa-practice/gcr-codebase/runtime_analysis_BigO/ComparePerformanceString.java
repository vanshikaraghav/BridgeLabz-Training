package runtime_analysis_BigO;

public class ComparePerformanceString {
    public static void main(String[] args) {
        int n = 100000;
        long start = System.currentTimeMillis();
        String s = "";
        for(int i=0;i<n;i++) {
            s += "hello";
        }
        System.out.println("String Time: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append("hello");
        }
        System.out.println("StringBuilder Time: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<n;i++) {
            sbf.append("hello");
        }
        System.out.println("StringBuffer Time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
