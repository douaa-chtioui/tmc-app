package tmc.ensi.org.tmcapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ChronicDisease {
    Disease disease ;
    boolean mechanicalValve ;
    boolean biologicalValve;
    boolean stentsPose ;
    boolean aortoCoronaryBypass ;
    boolean pacemaker;
    boolean defibrillator ;
    boolean tripleRoom;
    boolean ventricularFibrillation;

    public ChronicDisease() { }

    public Disease getDisease() {
        return disease;
    }

    public boolean isMechanicalValve() {
        return mechanicalValve;
    }

    public boolean isBiologicalValve() {
        return biologicalValve;
    }

    public boolean isStentsPose() {
        return stentsPose;
    }

    public boolean isAortoCoronaryBypass() {
        return aortoCoronaryBypass;
    }

    public boolean isPacemaker() {
        return pacemaker;
    }

    public boolean isDefibrillator() {
        return defibrillator;
    }

    public boolean isTripleRoom() {
        return tripleRoom;
    }

    public boolean isVentricularFibrillation() {
        return ventricularFibrillation;
    }


    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public void setMechanicalValve(boolean mechanicalValve) {
        this.mechanicalValve = mechanicalValve;
    }

    public void setBiologicalValve(boolean biologicalValve) {
        this.biologicalValve = biologicalValve;
    }

    public void setStentsPose(boolean stentsPose) {
        this.stentsPose = stentsPose;
    }

    public void setAortoCoronaryBypass(boolean aortoCoronaryBypass) {
        this.aortoCoronaryBypass = aortoCoronaryBypass;
    }

    public void setPacemaker(boolean pacemaker) {
        this.pacemaker = pacemaker;
    }

    public void setDefibrillator(boolean defibrillator) {
        this.defibrillator = defibrillator;
    }

    public void setTripleRoom(boolean tripleRoom) {
        this.tripleRoom = tripleRoom;
    }

    public void setVentricularFibrillation(boolean ventricularFibrillation) {
        this.ventricularFibrillation = ventricularFibrillation;
    }

    public static class Builder {
        private ChronicDisease chronicDisease = null;

        public Builder newChronicDisease() {
            this.chronicDisease = new ChronicDisease();
            return this;
        }

        public Builder withDisease(Disease disease) {
            this.chronicDisease.disease = disease ;
            return this;
        }

        public Builder withmechanicalValve(boolean mechanicalValve) {
            this.chronicDisease.mechanicalValve = mechanicalValve ;
            return this;
        }
        public Builder withBiologicalValve(boolean biologicalValve) {
            this.chronicDisease.biologicalValve = biologicalValve;
            return this;
        }
        public Builder withStentsPose(boolean stentsPose) {
            this.chronicDisease.stentsPose = stentsPose ;
            return this;
        }
        public Builder withAortoCoronaryBypass(boolean aortoCoronaryBypass) {
            this.chronicDisease.aortoCoronaryBypass = aortoCoronaryBypass ;
            return this;
        }
        public Builder withPacemaker(boolean pacemaker) {
            this.chronicDisease.pacemaker = pacemaker;
            return this;
        }
        public Builder withDefibrillator(boolean defibrillator) {
            this.chronicDisease.defibrillator = defibrillator ;
            return this;
        }
        public Builder withTripleRoom(boolean tripleRoom) {
            this.chronicDisease.tripleRoom = tripleRoom;
            return this;
        }
        public Builder withVentricularFibrillation(boolean ventricularFibrillation) {
            this.chronicDisease.ventricularFibrillation = ventricularFibrillation ;
            return this;
        }
        public ChronicDisease build() {
            return this.chronicDisease;
        }
    }
}

