package com.algoplay.visualgo.ModelClass;

public class Algorithm {
    String algoname;
    String algocreator;
    String details;

    public Algorithm(String algoname, String algocreator, String details) {
        this.algoname = algoname;
        this.algocreator = algocreator;
        this.details = details;
    }

    public String getAlgoname() {
        return algoname;
    }

    public void setAlgoname(String algoname) {
        this.algoname = algoname;
    }

    public String getAlgocreator() {
        return algocreator;
    }

    public void setAlgocreator(String algocreator) {
        this.algocreator = algocreator;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
