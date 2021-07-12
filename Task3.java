import java.util.*;

public class Task3 {
    public static void main(String[] args) {


        try {
            Scanner in = new Scanner(System.in);
            int count = 0;
            List<String> someText = new ArrayList<>();
            String pattern = ("[a-zA-Z],\s");


            System.out.println("Input word A: ");
            String wordA = in.nextLine();

            if (!wordA.equals(pattern)) throw new Exception("Error of num A");

            System.out.println("Input count of texts ");
            int countText = in.nextInt();

            if (countText >= 100 || countText <= 0) throw new Exception("Число M не подходит");
            //if (wordA.length()>=100 || wordA.length()<=0) throw new Exception("Чмсло А не подходит");

            for (int i = 0; i < countText + 1; i++) {
                System.out.print("Input text : ");
                String st = in.nextLine();
                someText.add(st);
            }


            Map<String, Integer> result = new HashMap<String, Integer>();
            for (int i = 0; i < someText.size(); i++) {
                String[] k = someText.get(i).split(" ");
                for (int j = 0; j < k.length; j++) {

                    if (k[j].contains(wordA)) {
                        count = count + 1;
                    }

                }
                result.put(someText.get(i), count);
                count = 0;
            }

            in.close();


            // сортировка
            result.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}



