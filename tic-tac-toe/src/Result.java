public class Result {
    public final boolean ok;
    public final Status status;
    public final Player winner;
    public final String message;

    public Result(boolean ok, Status status, Player winner, String message) {
        this.ok = ok;
        this.status = status;
        this.winner = winner;
        this.message = message;
    }
}
