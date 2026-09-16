import java.util.*;

public class prac4_ps1{
    public static void main(String[] args) {
            ArrayList<String>student = new ArrayList<>();
        student.add("ram");
        student.add("sam");
        student.add("shrey");
        student.add("vaibhav");
        student.add("shrutika");
        TreeSet<Integer> marks=new TreeSet<>();
        marks.add(89);
        marks.add(99);
        marks.add(97);
        marks.add(70);
        marks.add(45);

        HashMap<Integer, String> mp=new HashMap<>();
        mp.put(60,"Ram");
        mp.put(65,"Sam");
        mp.put(67,"Shrey");
        mp.put(70,"Vaibhav");
        mp.put(29,"Shrutika");

        System.out.println(student);
        System.out.println();
        System.out.println(marks);
        System.out.println();
        System.out.println(mp);
    }
}

