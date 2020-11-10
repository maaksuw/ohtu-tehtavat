
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    @Override
    public int compareTo(Player p) {
        return (p.getGoals() + p.getAssists()) - (this.getGoals() + this.getAssists());
    }

    @Override
    public String toString() {
        return name + "    " + team + "    " + goals + " + " + assists + " = " + (goals + assists);
    }
      
}
