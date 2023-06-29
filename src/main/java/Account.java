public class Account {

    private boolean active=false;
    private Adress defaulAdress;

    public Account(boolean active, Adress defaulAdress) {
        this.active = active;
        this.defaulAdress = defaulAdress;
    }

    public Account(Adress defaulAdress) {
        this.defaulAdress = defaulAdress;
        if(defaulAdress != null)
            activate();
        else
            this.active=false;
    }

    public Account(boolean active) {
        this.active = active;
    }
    public Account() {
    }

    public boolean isActive() {
        return active;
    }

    public void setDefaulAdress(Adress defaulAdress) {
        this.defaulAdress = defaulAdress;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void activate() {
        setActive(true);
    }

    public Adress getDefaulAdress() {
        return defaulAdress;
    }
}
