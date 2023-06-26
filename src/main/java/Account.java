public class Account {

    private boolean active=false;

    public Account(boolean active) {
        this.active = active;
    }
    public Account() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void activate() {
        setActive(true);
    }
}
