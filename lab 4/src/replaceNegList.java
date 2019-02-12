import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class replaceNegList {
    static void replaceNegList(List<Integer> l) {

        int pos = 0;

        for (int i = 0; i < l.size();i++) {// has to have a for loop since java does not like to modify while looking at list

            int temp = l.get(pos);

            if (temp < 0){
                l.remove(pos);
                temp = temp * -1;
                l.add(pos, temp);  }
            pos ++;
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vec1 = new Vector<Integer>();
        vec1.add(new Integer(-47));
        vec1.add(new Integer(-17));
        vec1.add(new Integer(-399));
        vec1.add(new Integer(-2));
        vec1.add(new Integer(-247));
        replaceNegList(vec1);
        System.out.println("Positive list hopefully: " + vec1);}
    }

