package codility;


public class BinaryPeriod {

    public int solution(int A) {
        String s = Integer.toBinaryString(A);
        return this.solution(s);
    }

    public int solution(String str) {
        for (int p = 1; p <= str.length() / 2; p++) {
            if (tryPeriod(p, str))
                return p;
        }
        return -1;
    }

    private boolean tryPeriod(int p, String str) {
        int nPeriods =  (str.length()/2)/p;
        for(int n = 0; n < nPeriods; n++) {
            int pos1 = n*p;
            int pos2 = n*p+p;
            String s1 = str.substring(pos1, pos2);
            String s2 = str.substring(pos2, pos2+p);
            if(!s1.equals(s2))
                return false;
        }
        return true;
    }


    static public void main(String[] args) {
        BinaryPeriod s = new BinaryPeriod();
//        int p = s.period("abracadabracadabra");
//        int p = s.period("abracadabracadabra");
        int p = s.solution("codi.codi.codi.co");
        p = s.solution("codilitycodilityco");
        System.out.println(p);
    }
}

