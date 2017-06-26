package example.codeclan.com.wrestling;

import java.sql.ResultSet;

import db.SqlRunner;

import java.sql.Date;

/**
 * Created by user on 26/06/2017.
 */

public class SearchResult {

    private int id;
    private String name;
    private String description;
    private String first_name;
    private String nick_name;
    private String last_name;
    private String telephone;
    private String email;
    private Date member_since;

    public SearchResult(String name, String description, String first_name, String nick_name, String last_name, String telephone, String email) {
        this.name = name;
        this.description = description;
        this.first_name = first_name;
        this.nick_name = nick_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Date getMember_since() {
        return member_since;
    }

    public static SearchResult findCounselorBySubject(String subject) {
        SearchResult searchResult = null;
        String sql = String.format("SELECT subjects.name, subjects.description, counselors.first_name, counselors.nick_name, counselors.last_name, counselors.telephone, counselors.email FROM subjects JOIN counselors ON counselors.id = subjects.counselor_id WHERE subjects.name = '%s';", subject);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while(rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String firstName = rs.getString("first_name");
                String nickName = rs.getString("nick_name");
                String lastName = rs.getString("last_name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");

                searchResult = new SearchResult(name, description, firstName, nickName, lastName, telephone, email);
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return searchResult;
    }

}

