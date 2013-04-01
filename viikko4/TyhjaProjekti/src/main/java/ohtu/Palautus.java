package ohtu;

public class Palautus  {


    private Long id;
    private String opiskelijanumero;
    private String etunimi;
    private String sukunimi;
    private String githubtunnus;
    private String jenkinstunnus;
    private int viikko;
    private int tunteja;
    private String tehtavat;
    private int tehtavia;

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getGithubtunnus() {
        return githubtunnus;
    }

    public void setGithubtunnus(String githubtunnus) {
        this.githubtunnus = githubtunnus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenkinstunnus() {
        return jenkinstunnus;
    }

    public void setJenkinstunnus(String jenkinstunnus) {
        this.jenkinstunnus = jenkinstunnus;
    }

    public String getOpiskelijanumero() {
        return opiskelijanumero;
    }

    public void setOpiskelijanumero(String opiskelijanumero) {
        this.opiskelijanumero = opiskelijanumero;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getTehtavat() {
        return tehtavat;
    }

    public void setTehtavat(String tehtavat) {
        this.tehtavat = tehtavat;
    }

    public int getTehtavia() {
        return tehtavia;
    }

    public void setTehtavia(int tehtavia) {
        this.tehtavia = tehtavia;
    }

    public int getTunteja() {
        return tunteja;
    }

    public void setTunteja(int tunteja) {
        this.tunteja = tunteja;
    }

    public int getViikko() {
        return viikko;
    }

    public void setViikko(int viikko) {
        this.viikko = viikko;
    }

    @Override
    public String toString() {
        return etunimi + " " + sukunimi + " (" + opiskelijanumero + ") github:" + githubtunnus
                + " jenkins:" + jenkinstunnus + " tunteja " + tunteja + " tehtävät: " + tehtavat+ " "
                + "eli palautettuja yhteensä "+tehtavia;
    }
}
