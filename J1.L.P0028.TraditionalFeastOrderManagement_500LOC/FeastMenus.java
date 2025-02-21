import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeastMenus {
    private List<FeastMenu> feastMenus = new ArrayList<>();

    public FeastMenus(String filePath) {
        feastMenus = readFile(filePath);
        for(FeastMenu m : feastMenus) System.out.println(m);

        
    }

    List<FeastMenu> getFeastMenus () {
        return this.feastMenus;
    }

    public FeastMenu getByCode(String feastCode) {
        for(FeastMenu f : feastMenus) {
            if(f.getCode().equals(feastCode)) return f;
        }

        return null;
    }

    public List<FeastMenu> readFile(String filePath) {
        List<FeastMenu> feasts = new ArrayList<>();
        try {
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
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
}
