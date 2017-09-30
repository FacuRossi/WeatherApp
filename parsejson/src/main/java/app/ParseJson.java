package app;

import app.model.Professional;
import com.sun.org.apache.xml.internal.utils.StringComparable;
import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Facundo on 9/28/2017.
 */
public class ParseJson {

    private static final String DATA = "[" +
            " {" +
            "   \"Name\": \"Marline Hickson\"," +
            "   \"Position\": \"Civil Engineer\"," +
            "   \"Scoring\": 15251" +
            " }," +
            " {" +
            "   \"Name\": \"Syreeta Halbrook\"," +
            "   \"Position\": \"Lawyer\"," +
            "   \"Scoring\": 17200" +
            " }," +
            " {" +
            "   \"Name\": \"Bruce Callas\"," +
            "   \"Position\": \"Industrial Engineer\"," +
            "   \"Scoring\": 12548" +
            " }," +
            " {" +
            "   \"Name\": \"Elliot Kiss\"," +
            "   \"Position\": \"Accountant\"," +
            "   \"Scoring\": 18542" +
            " }," +
            " {" +
            "   \"Name\": \"Deandre Dehoyos\"," +
            "   \"Position\": \"Computer Engineer\"," +
            "   \"Scoring\": 17256" +
            " }," +
            " {" +
            "   \"Name\": \"Carlton Madlock\"," +
            "   \"Position\": \"Lawyer\"," +
            "   \"Scoring\": 17300" +
            " }," +
            " {" +
            "   \"Name\": \"Jackson Stansel\"," +
            "   \"Position\": \"Computer Engineer\"," +
            "   \"Scoring\": 16587" +
            " }," +
            " {" +
            "   \"Name\": \"Wilda Cort\"," +
            "   \"Position\": \"Computer Engineer\"," +
            "   \"Scoring\": 16472" +
            " }" +
            "]";

    private JSONArray jsonArray;
    private List<Professional> professionalList;

    public ParseJson() {
        jsonArray = new JSONArray(DATA);
        this.populateProfessionalList();
    }

    private void populateProfessionalList(){
        professionalList = new ArrayList<>();
        Professional professional;
        for (int i = 0; i < jsonArray.length(); i++) {
            professional = new Professional(jsonArray.getJSONObject(i).getString("Name"),
                    jsonArray.getJSONObject(i).getString("Position"),
                    jsonArray.getJSONObject(i).getDouble("Scoring"),
                    i+1);
            professionalList.add(professional);
        }
    }


    public void increaseScoring(int percent){
        professionalList.forEach(t->{
            t.setScoring((t.getScoring()*(percent +100))/100);
        });
    }

    public void increaseScoring(int percent, String position){
        professionalList.forEach(t->{
            if(t.getPosition().equals(position)){
                t.setScoring((t.getScoring()*(percent +100))/100);
            }
        });
    }

    public void addProfessional(String name, String position, Double scoring){
        professionalList.add(new Professional(name,position,scoring, professionalList.size()+1));
    }

    public void sortByPosition(){
        professionalList.sort((p1 ,p2) -> (p1.getPosition().compareTo(p2.getPosition())));
    }

    public void sortByScoringIf(){
        professionalList.sort((p1,p2) -> {
            if(p1.getPosition().equals(p2.getPosition())){
                return p1.getScoring().compareTo(p2.getScoring());
            }
            return p1.getPosition().compareTo(p2.getPosition());
        });
    }

    public void setFinalsPositions(){
        final int[] i = {1};
        professionalList.forEach(t -> {
            t.setFinalPosition(i[0]);
            i[0]++;
        });
    }

    public void writeFileWithJsonData(String path) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter;
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(professionalList.toString());
        bufferedWriter.close();
    }

    @Override
    public String toString() {
        return "Professional List {\n" +
                  professionalList +
                '}';
    }
}
