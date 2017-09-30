package app.model;

/**
 * Created by Facundo on 9/28/2017.
 */
public class Professional {

    private String name;
    private String position;
    private Double scoring;
    private Integer initialPosition;
    private Integer finalPosition;


    public Professional(String name, String position, Double scoring, Integer initialPosition) {
        this.name = name;
        this.position = position;
        this.scoring = scoring;
        this.initialPosition = initialPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getScoring() {
        return scoring;
    }

    public void setScoring(Double scoring) {
        this.scoring = scoring;
    }

    public Integer getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Integer initialPosition) {
        this.initialPosition = initialPosition;
    }

    public Integer getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(Integer finalPosition) {
        this.finalPosition = finalPosition;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"position\":\"" + position + '\"' +
                ", \"scoring\":" + scoring +
                ", \"initialPosition\":" + initialPosition +
                ", \"finalPosition\":" + finalPosition +
                "}\n" ;
    }
}
