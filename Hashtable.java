// Key differences between HashMap & HashTable
// 1. HashMap is async (better for single-threaded as it uses less memory & is faster) and HashTable is sync!
// 2. HashMap can contain one null key and many null values, Hashtable doesn't accept any null key or value

// Hashtable general knowledge
// Hashtable is an array of nodes(or linked lists)
// capacity = # of buckets * load factor (default 0.75)
// default capacity is 16 in Java library implementation
// To expand after reaching capacity takes O(n)
// but amortized hashtable put/get is O(1) if no more than 1 value map to the same index (so we don't need to go thru a linked list)

class HashMap {
    // implementation of a hashmap

    // implementation of a hashtable

    // Override *must be both* equals() and hashCode() methods
    // tailor this equals() to objects of your desired class
    // equals() is used to compare keys in hashtale
    @Override
    public boolean equals(Object obj) {

    }

}
