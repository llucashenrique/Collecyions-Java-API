package set.basicoperation;

import java.util.Objects;

public class Guest {

    private String name;

    private int codeInvite;

    public Guest(String name, int codigoConvites) {
        this.name = name;
        this.codeInvite = codigoConvites;
    }

    public String getName() {
        return name;
    }

    public int getCodeInvite() {
        return codeInvite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest guest)) return false;
        return getCodeInvite() == guest.getCodeInvite();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodeInvite());
    }

    @Override
    public String toString() {
        return "GuestSet{" +
                "name='" + name + '\'' +
                ", codigoConvites=" + codeInvite +
                '}';
    }
}
