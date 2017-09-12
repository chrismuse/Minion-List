import java.util.Comparator;

/**
* MinionList class.
* @author Chris Muse
* @version 1
*/
public class Minion implements Comparable<Minion> {
    private String name; //name of minion
    private double height; //height of minion
    private int iQLevel; //IQ of minion

    /**
     * Constructor
     * @param name - name of Minion
     * @param height - height of Minion
     * @param iQLevel - iQLevel of Minion
     */
    public Minion(String name, double height, int iQLevel) {
        this.name = name;
        this.height = height;
        this.iQLevel = iQLevel;
    }

    /**
     * Equals
     * @return boolean true if they are equal, false otherwise
     * @param o - Object to compare to
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Minion)) {
            return false;
        }
        Minion m = (Minion) o;
        if (this.name.equals(m.name) && this.height == m.height
            && this.iQLevel == m.iQLevel) {
            return true;
        }
        return false;
    }

    /**
     * hashCode
     * @return int representing this object
     */
    public int hashCode() {
        double hash = 1;
        hash = hash * 31 + name.hashCode();
        hash = hash * 7 + height;
        hash = hash * 5 + iQLevel;
        return (int) hash;
    }

    /**
     * toString
     * @return String representation of Minion
     */
    public String toString() {
        return String.format("%s has IQ of %d and height of %.2f cm.", name,
            iQLevel, height);
    }

    /**
     * compareTo
     * @return int ordering Minions by name
     * @param other - Minion to compare to
     */
    public int compareTo(Minion other) {
        return this.name.compareTo(other.name);
    }

    /**
     * compareByHeight
     * @return Comparator
     */
    public Comparator<Minion> compareByHeight() {
        return new HeightComparator();
    }

    /**
     * compareByIQ
     * @return Comparator
     */
    public Comparator<Minion> compareByIQ() {
        return new IQComparator();
    }

    /**
     * Comparator class
     */
    private class HeightComparator implements Comparator<Minion> {
        public int compare(Minion check, Minion other) {
            double firstHeight = check.height;
            double secondHeight = other.height;
            double dif = firstHeight - secondHeight;
            if (dif > 0) {
                return 1;
            } else if (dif < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Comparator class
     */
    private class IQComparator implements Comparator<Minion> {
        public int compare(Minion check, Minion other) {
            double firstIQ = check.iQLevel;
            int secondIQ = other.iQLevel;
            double dif = firstIQ - secondIQ;
            if (dif > 0) {
                return 1;
            } else if (dif < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}