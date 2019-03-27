import java.io.*;
import java.nio.charset.Charset;

public class Main {

    static VectorHeap<Person> mainHeap = new VectorHeap<>();

    public static void main(String[] args){
        String fileName = "C:\\Users\\garoz\\Desktop\\2019\\Estructura de datos\\hdt8\\src\\pacientes.txt";
        File file = new File(fileName);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, Charset.defaultCharset());
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                String[] elements = line.split(",");
                Person newPatient = new Person(elements[0], elements[1], elements[2].replace(" ", ""));
                mainHeap.add(newPatient);
            }
            br.close();
        }catch (FileNotFoundException e){
            System.out.println("File not found");

        }catch (IOException e){
            System.out.println("Something else went wrong");
        }
        System.out.println(mainHeap.getFirst().name);
    }
}
