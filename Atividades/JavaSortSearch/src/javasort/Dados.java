
package javasort;
//import java.lang.Comparable;
public class Dados implements Comparable<Dados>{
   
    private int id;
    private String scorePhrase;
    private String title;
    private String platform;
    private double score;
    private String genre;
    private String editorsChoice;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the scorePhrase
     */
    public String getScorePhrase() {
        return scorePhrase;
    }

    /**
     * @param scorePhrase the scorePhrase to set
     */
    public void setScorePhrase(String scorePhrase) {
        this.scorePhrase = scorePhrase;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the editorsChoice
     */
    public String getEditorsChoice() {
        return editorsChoice;
    }

    /**
     * @param editorsChoice the editorsChoice to set
     */
    public void setEditorsChoice(String editorsChoice) {
        this.editorsChoice = editorsChoice;
    }

    /**
     * @return the releaseYear
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * @param releaseYear the releaseYear to set
     */
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    /**
     * @return the releaseMonth
     */
    public int getReleaseMonth() {
        return releaseMonth;
    }

    /**
     * @param releaseMonth the releaseMonth to set
     */
    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    /**
     * @return the releaseDay
     */
    public int getReleaseDay() {
        return releaseDay;
    }

    /**
     * @param releaseDay the releaseDay to set
     */
    public void setReleaseDay(int releaseDay) {
        this.releaseDay = releaseDay;
    }
    
    
    @Override    
    public int compareTo(Dados outroDado){
      return this.getTitle().compareTo(outroDado.getTitle());
    }
    
     @Override
    public String toString(){
        return getTitle()+ " : " + getGenre() + " : " + getScore() + "(" + getScorePhrase()  + ")";
    }// fim toString
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dados dados = (Dados) o;
        return title.equals(dados.title);
    }
    

}
