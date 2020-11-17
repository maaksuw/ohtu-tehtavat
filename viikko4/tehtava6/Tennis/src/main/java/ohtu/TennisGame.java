package ohtu;

public class TennisGame {
    
    private int player1score = 0;
    private int player2score = 0;
    private String player1;
    private String player2;

    public TennisGame(String player1Name, String player2Name) {
        player1 = player1Name;
        player2 = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) player1score += 1;
        else player2score += 1;
    }

    public String getScore() {
        
        if (player1score == player2score) {
            return equalPoints();
        } else if (playerThreatensToWin()) {
            
            if(gameOver()) return "Win for " + leadingPlayer();
            return "Advantage " + leadingPlayer();
            
        } else {
            return getScoreAsString(player1score) + "-" + getScoreAsString(player2score);
        }
    }
    
    private String equalPoints() {
        int score = player1score;
        if(score <= 3) return getScoreAsString(score) + "-All";
        return "Deuce";
    }
    
    private boolean gameOver() {
        if(player1score >= 4 && (player1score - player2score) >= 2) return true;
        if(player2score >= 4 && (player2score - player1score) >= 2) return true;
        return false;
    }
    
    private String leadingPlayer() {
        if(player1score > player2score) return player1;
        if(player2score > player1score) return player2;
        return "";
    }
    
    private String getScoreAsString(int score) {
        if(score == 0) return "Love";
        if(score == 1) return "Fifteen";
        if(score == 2) return "Thirty";
        return "Forty";
    }
    
    private boolean playerThreatensToWin() {
        if(player1score >= 4 || player2score >= 4) return true;
        return false;
    }
}