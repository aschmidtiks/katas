package logic;

public class Board {

    private Slot[][] slots = new Slot[8][8];

    public Board(Slot[][] slots) {
        for (int i = 0; i < slots.length; i++) {
            for (int j = 0; j < slots[0].length; j++) {
                this.slots[i][j] = slots[i][j];
            }
        }
    }

    public Slot[][] getSlots() {
        return slots;
    }

    public void setSlot(Slot slotValue, int y, int x) {
        slots[y][x] = slotValue;
    }
}
