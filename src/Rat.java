public class Rat {
    String name;
    boolean isSickOrInjured;

    public Rat(String name, boolean isSickOrInjured) {
        this.name = name;
        this.isSickOrInjured = isSickOrInjured;
    }

    public void setHealthStatus(boolean isSickOrInjured) {
        this.isSickOrInjured = isSickOrInjured;
    }

    @Override
    public String toString() {
        return name + " (Sick/Injured: " + isSickOrInjured + ")";
    }
}
