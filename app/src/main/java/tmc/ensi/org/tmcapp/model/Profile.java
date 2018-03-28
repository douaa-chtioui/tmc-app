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

    public static class Builder {
        private Profile profile = null;

        public Builder newProfile() {
            this.profile = new Profile();
            return this;
        }

        public Builder withGender(Gender gender) {
            this.profile.gender = gender;
            return this;
        }
        public Builder withMenopause(boolean menopause) {
            this.profile.menopause = menopause;
            return this;
        }
        public Builder withHeight(int height) {
            this.profile.height = height;
            return this;
        }

        public Builder withWeight(int weight) {
            this.profile.weight = weight;
            return this;
        }


        public Builder withSmoker(boolean smoker) {
            this.profile.smoker = smoker;
            return this;
        }

        public Builder withMarried(boolean Married) {
            this.profile.married = Married;
            return this;
        }

        public Builder withDiabetic(boolean Diabetic) {
            this.profile.diabetic = Diabetic;
            return this;
        }

        public Builder withHypertensive(boolean Hypertensive) {
            this.profile.hypertensive = Hypertensive;
            return this;
        }

        public Builder withDyslipidemic(boolean Dyslipidemic) {
            this.profile.dyslipidemic = Dyslipidemic;
            return this;
        }


        public Builder withPersonalAntecedent(boolean PersonalAntecedent) {
            this.profile.personalAntecedent = PersonalAntecedent;
            return this;
        }


        public Builder withFamilyAntecedent(boolean familyAntecedent) {
            this.profile.familyAntecedent = familyAntecedent;
            return this;
        }


        public Profile build() {
            return this.profile;
        }
    }
}
