class NumberedItem<T> {

    private T item; // The item of generic type T
    private int index; // The index associated with the item

    //-----------------------------------------------------
    // Constructor for NumberedItem.
    // @param index The index for the item. If a negative index is provided, it is set to 0.
    // @param item The item to be stored.
     //-----------------------------------------------------
    public NumberedItem(int index, T item) {
        this.item = item;
        // Ensure the index is non-negative
        this.index = Math.max(index, 0);
    }

    //-----------------------------------------------------
    // Gets the index of the item.
    // @return The index of the item.
    //-----------------------------------------------------
    public int getIndex() {
        return this.index;
    }

    //-----------------------------------------------------
    // Compares this NumberedItem with another NumberedItem based on their indices.
    // @param other The NumberedItem to compare with.
    // @return A negative integer, zero, or a positive integer as this item's index
    //         is less than, equal to, or greater than the specified item's index.
    //-----------------------------------------------------
    public int compareTo(NumberedItem<T> other) {
        return this.getIndex() - other.getIndex();
    }

    //-----------------------------------------------------
    // Checks if this NumberedItem is equal to another NumberedItem.
    // Equality is based on the index.
    // @param other The NumberedItem to compare with.
    // @return true if both items have the same index, false otherwise.
    //-----------------------------------------------------
    public boolean equals(NumberedItem<T> other) {
        if (other == null) return false;
        return this.getIndex() == other.getIndex();
    }

    //-----------------------------------------------------
    // Returns a string representation of the NumberedItem.
    // @return A string in the format "Index: [index] Value: [item]".
    //-----------------------------------------------------
    @Override
    public String toString() {
        return "Index: " + this.index + " Value: " + this.item;
    }
}

