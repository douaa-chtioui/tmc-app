package tmc.ensi.org.tmcapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {

    private Gender gender;
    private boolean menopause ;
    private int height;
    private int weight;
    private boolean smoker;
    private boolean married;
    private boolean diabetic;
    private boolean hypertensive;
    private boolean dyslipidemic;
    private boolean personalAntecedent;
    private boolean familyAntecedent;

    public Profile() { }

    public int getHeight() { return height; }

    public int getWeight() { return weight; }

    public Gender getGender() {
        return gender;
    }

    public boolean isMenopause() { return menopause; }

    public boolean isSmoker() {
        return smoker;
    }

    public boolean isMarried() {
        return married;
    }

    public boolean isDiabetic() {
        return diabetic;
    }

    public boolean isHypertensive() {
        return hypertensive;
    }

    public boolean isDyslipidemic() {
        return dyslipidemic;
    }

    public boolean isPersonalAntecedent() {
        return personalAntecedent;
    }

    public boolean isFamilyAntecedent() {
        return familyAntecedent;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMenopause(boolean menopause) {
        this.menopause = menopause;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    public void setHypertensive(boolean hypertensive) {
        this.hypertensive = hypertensive;
    }

    public void setDyslipidemic(boolean dyslipidemic) {
        this.dyslipidemic = dyslipidemic;
    }

    public void setPersonalAntecedent(boolean personalAntecedent) {
        this.personalAntecedent = personalAntecedent;
    }

    public void setFamilyAntecedent(boolean familyAntecedent) {
        this.familyAntecedent = familyAntecedent;
    }
}
