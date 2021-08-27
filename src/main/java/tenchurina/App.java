package tenchurina;

import java.io.*;
import java.util.ArrayList;

public class App {
    public static void main( String[] args )  {

        File file1 = new File("src\\main\\resources\\questions");
        File file2 = new File("src\\main\\resources\\students");

        ArrayList<String> listQustions = createList(file1);
        ArrayList<String> listStudents = createList(file2);
         //Перемешиваем вопросы
        listQustions = ShuffleQuestions(listQustions);
        //Создаем новый файл
        createFileFull(listQustions,listStudents);
    }

        public static ArrayList<String> createList(File file)  {
            ArrayList<String> list = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"))) {

                String sCurrentLine;

                while ((sCurrentLine = br.readLine()) != null) {
                    list.add(sCurrentLine);
                   // System.out.println(sCurrentLine);
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
                list.set(i,list.get(index));
                list.set(index,temp);
            }
           // list.stream().forEach(System.out::println);
            return list;
        }

        public static void createFileFull(ArrayList <String> listQ,ArrayList <String> listS){
            String str = null;
            char ch= '\n';
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream("src\\main\\resources\\general", true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

                for (int i = 0; i < listS.size(); i++) {
                    str = listS.get(i) + " " + listQ.get(i);
                    try {
                        fileOut.write(str.getBytes());
                        fileOut.write(ch);
                    } catch (IOException e) {
                        System.err.println("Запись в файл не удалась");
                    }
                }
        }
}

