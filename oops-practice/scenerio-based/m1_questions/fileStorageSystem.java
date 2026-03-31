package m1_questions;
import java.util.*;

public class fileStorageSystem{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, LinkedHashMap<String,Integer>> map = new HashMap<>();

        while(n-- > 0){

            String[] p = sc.nextLine().split(" ");
            String op = p[0];

            if(op.equals("UPLOAD")){
                map.putIfAbsent(p[1], new LinkedHashMap<>());
                map.get(p[1]).putIfAbsent(p[2], Integer.parseInt(p[3]));
            }

            else if(op.equals("FETCH")){
                if(!map.containsKey(p[1])){
                    System.out.println("File Not Found");
                    continue;
                }

                List<Map.Entry<String,Integer>> list =
                        new ArrayList<>(map.get(p[1]).entrySet());

                list.sort((a,b)-> a.getValue()==b.getValue() ?
                        a.getKey().compareTo(b.getKey()) :
                        a.getValue()-b.getValue());

                for(Map.Entry<String,Integer> e : list)
                    System.out.println(p[1]+" "+e.getKey()+" "+e.getValue());
            }

            else if(op.equals("LATEST")){
                if(!map.containsKey(p[1])){
                    System.out.println("File Not Found");
                    continue;
                }

                String v=""; int s=0;
                for(Map.Entry<String,Integer> e: map.get(p[1]).entrySet()){
                    v=e.getKey(); s=e.getValue();
                }
                System.out.println(p[1]+" "+v+" "+s);
            }

            else if(op.equals("TOTAL_STORAGE")){
                if(!map.containsKey(p[1])){
                    System.out.println("File Not Found");
                    continue;
                }

                int sum=0;
                for(int x: map.get(p[1]).values()) sum+=x;
                System.out.println(p[1]+" "+sum);
            }
        }
    }
}