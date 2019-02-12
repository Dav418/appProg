import java.util.*;

class Lab4
{
    public static <T extends Comparable<T>> int smallest(List<T> l)
    {
        if (l.size()==0) return -1;
        else
        {
            Iterator<T> it = l.iterator();
            T smallestSoFar = it.next();
            T temp;
            int smallestPos = 0;
            int i = 1; //used to indicate position in list of next item
            while (it.hasNext()){
                temp = it.next();
               // System.out.println(temp + " :: "+smallestSoFar);
                    if(smallestSoFar.compareTo(temp) > 0){
                        smallestSoFar = temp;
                        smallestPos = i;
                    }
                    //else if(smallestSoFar.compareTo(temp) == 0){}
                i++;
            }
            return smallestPos;
        }

    }

    public static <T extends Comparable<T>> void deleteSmallest(List<T> l)
    {
        int smallPos = smallest(l);
        l.remove(smallPos);
    }

    public static void main(String[] args)
    {
        Vector<String> vec1 = new Vector<String>();

        vec1.add("world");
        vec1.add("xxxx");
        vec1.add("aardvark");
        vec1.add("Hello");
        int smallPos = smallest(vec1);

        if (smallPos!=-1) {
            System.out.println("smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos);
            deleteSmallest(vec1);
            System.out.println("Deleted the smallest object, new list is" + vec1);
        }
        Vector<Integer> vec2 = new Vector<Integer>();
        vec2.add(new Integer(47));
        vec2.add(new Integer(17));
        vec2.add(new Integer(399));
        vec2.add(new Integer(2));
        vec2.add(new Integer(247));

        smallPos = smallest(vec2);
        if (smallPos!=-1){
            System.out.println("smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos);
            deleteSmallest(vec2);
            System.out.println("Deleted the smallest object, new list is" + vec2);}
    }
}
