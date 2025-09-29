class Foo {
    Integer i;
    Boolean b;
    String s;
    
    Foo(Integer i, Boolean b, String s) {
        this.i = i;
        this.b = b;
        this.s = s;
    }
    
    @Override
    public int hashCode() {
        int hash = 17;
        hash = i.hashCode() + 31 * hash;
        hash = b.hashCode() + 31 * hash;
        hash = s.hashCode() + 31 * hash;  
        return hash;
    }   
    
    @Override
    public boolean equals(Object o) {
        // Check if same reference
        if (this == o) return true;
        
        // Check if null or different class
        if (o == null || getClass() != o.getClass()) return false;
        
        Foo f = (Foo) o;
        
        // Check all fields for equality
        if (f.i.equals(i) && f.b.equals(b) && f.s.equals(s)) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Foo{i=" + i + ", b=" + b + ", s='" + s + "'}";
    }
} 

public class TestHashTable {
    public static void main(String[] args) {
        // Using HashMap instead of HashTable (HashTable is older, HashMap is preferred)
        java.util.HashMap<Foo, Integer> map = new java.util.HashMap<>();
        
        Foo foo1 = new Foo(5, false, "hello");
        Foo foo2 = new Foo(7, true, "hello1");
        Foo foo3 = new Foo(1, false, "hello67");
        
        map.put(foo1, 7);
        map.put(foo2, 6);
        map.put(foo3, 8); // Changed from 5 to 8 to match the assertion
        
        // Assertions
        assert map.get(foo2) == 6 : "Expected 6 for foo2";
        assert map.get(foo1) == 7 : "Expected 7 for foo1"; 
        assert map.get(foo3) == 8 : "Expected 8 for foo3"; // This was expecting 8 but you put 5
        
        // Test output
        System.out.println("foo1 hashCode: " + foo1.hashCode());
        System.out.println("foo2 hashCode: " + foo2.hashCode());
        System.out.println("foo3 hashCode: " + foo3.hashCode());
        
        System.out.println("\nMap contents:");
        System.out.println("foo1 -> " + map.get(foo1));
        System.out.println("foo2 -> " + map.get(foo2));
        System.out.println("foo3 -> " + map.get(foo3));
        
        // Test equality
        Foo foo1Copy = new Foo(5, false, "hello");
        System.out.println("\nTesting equality:");
        System.out.println("foo1.equals(foo1Copy): " + foo1.equals(foo1Copy));
        System.out.println("foo1.hashCode() == foo1Copy.hashCode(): " + (foo1.hashCode() == foo1Copy.hashCode()));
        System.out.println("map.get(foo1Copy): " + map.get(foo1Copy)); // Should return 7
        
        System.out.println("\nAll tests passed!");
    }
}