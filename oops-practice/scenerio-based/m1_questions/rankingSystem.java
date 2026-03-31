package m1_questions;

import java.util.*;

public class rankingSystem {
    static class Student {
        String name, dept;
        int q1, q2, q3;

        Student(String n, String d, int a, int b, int c){
            name=n; dept=d; q1=a; q2=b; q3=c;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Student> list = new ArrayList<>();

        while(n-- > 0){

            String[] p = sc.nextLine().split(" ");

            if(p[0].equals("Record")){
                Student s = new Student(p[1], p[2],
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4]),
                        Integer.parseInt(p[5]));

                list.add(s);
                System.out.println("Record Added: " + s.name);
            }

            else if(p[0].equals("Top")){

                if(list.isEmpty()){
                    System.out.println("No Records Available");
                    continue;
                }

                String key = p[1];

                // Top by Department
                if(!key.startsWith("Q")){
                    int max = -1;
                    List<Student> res = new ArrayList<>();

                    for(Student s : list){
                        if(s.dept.equals(key)){
                            int total = s.q1 + s.q2 + s.q3;

                            if(total > max){
                                max = total;
                                res.clear();
                                res.add(s);
                            } else if(total == max){
                                res.add(s);
                            }
                        }
                    }

                    if(max == -1){
                        System.out.println("Department Not Found");
                    } else {
                        for(Student s : res){
                            System.out.println(s.name + " " + max);
                        }
                    }
                }

                // Top by Quiz (Q1, Q2, Q3)
                else{
                    int max = -1;
                    List<Student> res = new ArrayList<>();

                    for(Student s : list){
                        int val = key.equals("Q1") ? s.q1 :
                                  key.equals("Q2") ? s.q2 : s.q3;

                        if(val > max){
                            max = val;
                            res.clear();
                            res.add(s);
                        } else if(val == max){
                            res.add(s);
                        }
                    }

                    for(Student s : res){
                        int val = key.equals("Q1") ? s.q1 :
                                  key.equals("Q2") ? s.q2 : s.q3;
                        System.out.println(s.name + " " + val);
                    }
                }
            }
        }
    }
}