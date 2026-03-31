import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        int n=x; //x will be safe
        int rem,rev=0;
        while(n>0){
         rem=n%10; //last digit of n is stored in rem
         rev=rev*10 + rem; //we are now adding the remainders one by one to our rev.
         n=n/10; //removing the last digit from n, as it had been already added to rev
        }
        if(rev==x){
            return true;
        }
        return false;
        
    }
    }