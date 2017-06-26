package example.codeclan.com.wrestling;

/**
 * Created by user on 26/06/2017.
 */

public class Runner {

    public static void main(String[] args) {
        //Counselor.all();

        Counselor searchCounselor = Counselor.findCounselorByid(1);
        System.out.println(searchCounselor.getFirst_name());


    }
}
