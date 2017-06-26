package example.codeclan.com.wrestling;

import java.sql.ResultSet;

import db.SqlRunner;

import java.sql.Date;

/**
 * Created by user on 26/06/2017.
 */

public class Counselor {

    private int id;
    private String first_name;
    private String nick_name;
    private String last_name;
    private String telephone;
    private String email;
    private Date member_since;

    public Counselor(String first_name, String nick_name, String last_name, String telephone, String email, Date member_since) {
        this.first_name = first_name;
        this.nick_name = nick_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.email = email;
        this.member_since = member_since;
    }

    public Counselor(int id, String first_name, String nick_name, String last_name, String telephone, String email) {
        this.first_name = first_name;
        this.nick_name = nick_name;
        this.last_name = last_name;
        this.telephone = telephone;
        this.email = email;
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


    public void save() {
        String sql = String.format("INSERT INTO counselors (first_name, nick_name, last_name, telephone, email, member_since) VALUES ('%s', '%s', '%s', '%s', '%s', %d);", this.first_name, this.nick_name, this.last_name, this.telephone, this.email, this.member_since);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all() {
        String sql = "SELECT * FROM counselors;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String nickName = rs.getString("nick_name");
                String lastName = rs.getString("last_name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                //String memberSince = rs.getString("member_since");
                System.out.println(firstName);
                System.out.println(nickName);
                System.out.println(lastName);
                System.out.println(telephone);
                System.out.println(email);
                //System.out.println(memberSince);
                System.out.println();
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static Counselor findCounselorByid(int id) {
        Counselor counselor = null;
        String sql = String.format("SELECT * FROM counselors WHERE id = '%d' ;", id);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while(rs.next()) {
                id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String nickName = rs.getString("nick_name");
                String lastName = rs.getString("last_name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");

                counselor = new Counselor(id, firstName, nickName, lastName, telephone, email);
            }
        } catch (Exception ex) {
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
        return counselor;
    }



}
