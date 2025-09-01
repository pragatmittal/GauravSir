public class car {
    private int size;
    private int color;
    car(int size, int color) {
        this.size = size;
        this.color = color;
    }
    public int getSize() {
        return this.size;
    }
    public int getColor() {
        return this.color;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setColor(int color) {
        this.color = color;
    }
    public boolean equals(Object obj) {
        car c=(car)obj;
        if(this.size==c.size && this.color==c.color){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        car car1=new car(5,6);
        car car2=new car(5,6);
        System.out.println(car1==car2); // now it will call the equals method of object class and return false
        System.out.println(car1.equals(car2)); // now it will call the equals method of car class and return true
        // every class inherits from object class
        // class car inheriting from object class
        // overriding equals method
        //object class has multiple methods
        // toString,hashCode,equals,finalize,getClass,notify,notifyAll,wait
        //toString method
        //object class has two methods
        //== operator and equals method and hashCode method
        // public method boolean equals(object obj)
        //what would be the  line 23 &24 ->
        //23 -> false and the reason is that both are different objects
        //24 -> false because equals method in object class is same as == operator
        // car1 and car2 have different 2 reference and two different address and if ur trying to compare two different address it will return false
        // if we dont define equals it by default calls the equals method of object class returing false


    }
}
