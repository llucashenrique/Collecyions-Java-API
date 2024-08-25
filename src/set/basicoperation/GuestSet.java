package set.basicoperation;

import java.util.HashSet;
import java.util.Set;

public class GuestSet {


    private Set<Guest> guestSet;

    public GuestSet() {
        this.guestSet = new HashSet<>();
    }


    public void addGuest(String name, int codeConvites) {
        guestSet.add(new Guest(name, codeConvites));
    }


    public void removeGuestByCodeInvitation(int codeInvitation) {
        Guest guestForRemove = null;
        for (Guest guest : guestSet) {
            if (guest.getCodeInvite() == codeInvitation) {
                guestForRemove = guest;
                break;
            } else {
                System.out.println("no exists the guest");
            }
        }
        guestSet.remove(guestForRemove);
    }


    public int countGuests() {
        return guestSet.size();
    }

    public void displayGuests() {
        System.out.println(guestSet);
    }

    public static void main(String[] args) {
        GuestSet guestsSet = new GuestSet();

        guestsSet.addGuest("Guest 1", 1258);
        guestsSet.addGuest("Guest 2", 1258);
        guestsSet.addGuest("Guest 3", 1298);
        guestsSet.addGuest("Guest 4", 1287);

        System.out.println("Exists: " + guestsSet.countGuests() + " guests Inside of guestSet");

        guestsSet.removeGuestByCodeInvitation(1298);
        System.out.println("Exists: " + guestsSet.countGuests() + " guests Inside of guestSet");

        guestsSet.displayGuests();
    }
}
