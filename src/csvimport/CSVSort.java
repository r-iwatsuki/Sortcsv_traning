package csvimport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CSVSort extends StudentList {
    public static void main(String[] args) throws FileNotFoundException,
            IOException {

        CSVSort aq = new CSVSort();
        aq.readData("9.csv");
        aq.sortData();
        aq.writeData("19.csv");

    }
}
/**
 * 学籍番号、氏名、国語、英語、数学の点数、合計点を格納するStudentクラス
 */
class Student {

    /**
     * 学籍番号を表します
     */
    protected int number;

    /**
     * 氏名を表します
     */
    protected String name;

    /**
     * 国語の点数を表します
     */
    protected int japanese;

    /**
     * 数学の点数を表します
     */
    protected int math;

    /**
     * 英語の点数を表します
     */
    protected int english;

    /**
     * 合計点を表します
     */
    protected int total;

    /**
     * 学籍番号、氏名、国語、数学、英語の点数を設定するコンストラクタ
     */
    public Student(int n, String N, int j, int m, int e) {
        number = n;
        name = N;
        japanese = j;
        math = m;
        english = e;
    }

    /**
     * 学籍番号を返すメソッド
     */
    public int getNumber() {
        return number;
    }

    /**
     * 氏名を返すメソッド
     */
    public String getName() {
        return name;
    }

    /**
     * 国語の点数を返すメソッド
     */
    public int getJapanese() {
        return japanese;
    }

    /**
     * 数学の点数を返すメソッド
     */
    public int getMath() {
        return math;
    }

    /**
     * 英語の点数を返すメソッド
     */
    public int getEnglish() {
        return english;
    }

    /**
     * 合計点を返すメソッド
     */
    public int getTotal() {
        return total;
    }

    /**
     * 国語、数学、英語の合計点を計算してセットするメソッド
     */
    public void setTotal(int a, int b, int c) {
        total = a + b + c;
    }
}

class StudentList {
    /**
     * ArrayList<Student>型のprotectedメンバーの実装
     */
    protected ArrayList<Student> al = new ArrayList<Student>();
    protected String line;

    /**
     * ファイル名を引数として、ファイルの内容をArrayListに保存する
     */
    public void readData(String name) {
        try (BufferedReader in = new BufferedReader(new FileReader(name))) {
            while ((line = in.readLine()) != null) {
                String[] als = line.split(",");
                Student as = new Student(Integer.parseInt(als[0]), als[1],
                        Integer.parseInt(als[2]), Integer.parseInt(als[3]),
                        Integer.parseInt(als[4]));
                as.setTotal(Integer.parseInt(als[2]), Integer.parseInt(als[3]),
                        Integer.parseInt(als[4]));
                al.add(as);
            }
        } catch (Exception e) {
        }
    }

    public void writeData(String name) {
        try (BufferedWriter in = new BufferedWriter(new FileWriter(name))) {

                     for (int i=0;i<al.size();i++) {
                in.write(al.get(i).getNumber() + "," + al.get(i).getName() + ","
                        + al.get(i).getJapanese() + "," + al.get(i).getMath() + ","
                        + al.get(i).getEnglish() + "," + al.get(i).getTotal());
                in.newLine();
            }


        } catch (Exception e) {
        }
    }

    /**
     * ArrayListに格納されたデータを合計点の高い順にソートするメソッド
     */
    public void sortData() {

        Collections.sort(al, new N());
    }

}

class N implements Comparator<Student> {

    public int compare(Student b, Student c) {

        Integer n = b.getTotal();
        Integer m = c.getTotal();
        return m.compareTo(n);
    }

}