
package statistics.matcher;

public class QueryBuilder {
    
    Matcher m;
    
    public QueryBuilder() {
        m = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.m = new And(this.m , new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int amount, String method) {
        this.m = new And(this.m , new HasAtLeast(amount, method));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int amount, String method) {
        this.m = new And(this.m , new HasFewerThan(amount, method));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.m = new Or(m1, m2);
        return this;
    }
    
    public Matcher build() {
        Matcher m1 = m;
        m = new All();
        return m1;
    }
    
}
