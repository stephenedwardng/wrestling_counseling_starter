package example.codeclan.com.wrestling;

/**
 * Created by user on 26/06/2017.
 */

public class Runner {

    public static void main(String[] args) {

        SearchResult searchSubject = SearchResult.findCounselorBySubject("Hypnosis");
        System.out.println(searchSubject.getName());
        System.out.println(searchSubject.getDescription());
        System.out.println(searchSubject.getFirst_name());
        System.out.println(searchSubject.getNick_name());
        System.out.println(searchSubject.getLast_name());
        System.out.println(searchSubject.getTelephone());
        System.out.println(searchSubject.getEmail());

    }
}
