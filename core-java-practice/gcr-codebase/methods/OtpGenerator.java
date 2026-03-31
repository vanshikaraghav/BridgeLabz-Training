package methods;

public class OtpGenerator {
	
	public static int generateOTP() {
        return 100000 + (int)(Math.random()*900000);
    }

    public static boolean areOTPsUnique(int[] otps) {
        for(int i=0;i<otps.length;i++) {
            for(int j=i+1;j<otps.length;j++) {
                if(otps[i]==otps[j]) {
                   return false;
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] otpArray = new int[10];
        for(int i=0;i<10;i++) {
            otpArray[i] = generateOTP();
        }
        System.out.println("Generated OTPs:");
        for(int otp : otpArray) {
            System.out.println(otp);
        }
        if(areOTPsUnique(otpArray)) {
            System.out.println("All OTPs are unique.");
        }else {
            System.out.println("Some OTPs are repeated.");
        }
	}

}
