package tenchurina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main( String[] args ) {
        File file1 = new File("questions.txt", "UTF_8");
        File file2 = new File("students.txt", "UTF_8");
        ArrayList<String> listQustions = createList(file1);
        ArrayList<String> listStudents = createList(file2);
        // Перемешиваем вопросы
        listQustions = ShuffleQuestions(listQustions);
    }



        public static ArrayList<String> createList(File fileL) {
            BufferedReader reader;
            ArrayList<String> list = new ArrayList<>();
            try {
                reader = new BufferedReader(new FileReader(fileL));
                String line = reader.readLine();
                while (line != null) {
                    list.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                System.err.println("При чтении файла произошла ошибка " + e);
            }
            return list;
        }

        public static ArrayList<String> ShuffleQuestions(ArrayList<String> list){
            int index;
            String temp;
            for (int i = 0; i < list.size(); i++) {
                index = (int)(Math.random() * list.size());
                temp = list.get(i);
                list.add(i,list.get(index));
                list.add(index,temp);
                System.out.println(list.get(i));
            }
            return list;
        }
}

