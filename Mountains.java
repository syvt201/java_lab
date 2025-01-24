import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Mountains {
    private String pathFile;
    private ArrayList<Mountain> mountains = new ArrayList<>();

    public Mountains() {
        pathFile = "";
        readFromFile();
    }

    public Mountains(String pathFile) {
        this.pathFile = pathFile;
        readFromFile();
    }

    public Mountain get(String mountainCode) {
        for(Mountain m : mountains) {
            if(m.getMountainCode().equals(mountainCode)) return m;
        }

        return null; // return null if not found
    }

    public boolean isValidMountainCode(String mountainCode) {
        if(mountainCode == null || mountainCode.isEmpty()) return false;
        return mountainCode.matches("\\d+");
    }

    public Mountain searchMountain(String code) {
        for(Mountain m : this.mountains) {
            if(m.getMountainCode().equals(code)) return m;
        }

        return null;
    }

    public Mountain dataToObject(String text) {
        // 2, Doi Bo Mountain, Lao Cai, 
        // 1, Ham Rong Mountain, Lao Cai, Located near the center of Sa Pa town. The highest point is 1850m above sea level.
        String[] tokens = text.split(", ");
        String code = tokens[0];
        String mountain = tokens[1];
        String province = tokens[2];
        String description = "";
        if(tokens.length > 3) description = tokens[3];

        return new Mountain(code, mountain, province, description);
    }

    public void readFromFile() {
        File file = new File(this.pathFile);

        try {
            Scanner sc = new Scanner(file);
            int index = 0;

            while(sc.hasNextLine()) {
                String text = sc.nextLine();
                if(index == 0) {
                    index++;
                    continue;
                }

                index++;
                if(text == null || text.length() == 0) continue;
                Mountain mt = dataToObject(text);
                this.mountains.add(mt);
            }
            sc.close();

        } catch(Exception e) {
            e.printStackTrace();
        } 
    }

    // public void display () {
    //     for(Mountain mt : this.mountains) {
    //         System.out.println(mt.toString());
    //     }
    // }
}
