package Utilities;

public class Team {

    public String teamName, teamEmail;

    public Team(String name, String email) {
        this.teamName = name;
        this.teamEmail = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "teamName='" + teamName + '\'' +
                ", teamEmail='" + teamEmail + '\'' +
                '}';
    }
}
