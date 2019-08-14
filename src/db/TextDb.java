package db;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TextDb<E> implements DbStrategy<E> {
    private String file;
    private List<String[]> items;


    public TextDb() {
        this.file = "src//testdata//item.txt";
        this.items = new ArrayList<String[]>() {
        };


    }


    @Override
    public void save() {
        String towrite = "";
        for (String[] c: items) {
            for(int i=0;i<c.length;i++)
            towrite += c[i]+ ",";

            towrite+="\n";
        }

        try {

            OutputStream out =  new FileOutputStream(this.file);
            OutputStreamWriter ow = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(ow);
            bw.flush();
            bw.write(towrite);
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    @Override
    public void load() {
        List<String[]> text = new ArrayList<>();

        String fileName = "src//testdata//item.txt";

        String line = null;

        try {

            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
               // System.out.println(line);
                String[] split = line.split(",");
                text.add(split);

            }


            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

        }
        this.items=text;
    }


    public List<String[]> getItems() {
        return items;
    }

    public void setItems(List<String[]> items) {
        this.items = items;
    }
}
