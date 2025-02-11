import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeastMenus {
    private List<FeastMenu> feastMenus = new ArrayList<>();

    public FeastMenus(String filePath) {
        feastMenus = readFile(filePath);
    }

    public FeastMenu getByCode(String feastCode) {
        for(FeastMenu f : feastMenus) {
            if(f.getCode().equals(feastCode)) return f;
        }

        return null;
    }

    private List<FeastMenu> readFile(String filePath) {
        List<FeastMenu> feasts = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            
            int index = 0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line == null || line.length() == 0) continue;
                if(index == 0) {
                    index++;
                    continue;
                }

                index++;
                String tokens[] = line.trim().split(",");
                String code = tokens[0];
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                String ingredients = tokens[3];
                feasts.add(new FeastMenu(code, name, price, ingredients));
            }

            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return feasts;
    }

    public static void main(String[] args) {
        FeastMenus fms = new FeastMenus("FeastMenu.csv");
        System.out.println(fms.feastMenus.size());
        for(FeastMenu f : fms.feastMenus)  System.out.println(f);
    }
}
