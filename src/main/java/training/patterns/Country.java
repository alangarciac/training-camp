package training.patterns;

public enum Country {

    CHINA {
        @Override
        public <T, J> T accept(CountryVisitor<T, J> visitor, J data) {
            return visitor.visitChina(data);
        }
    },
    INDIA {
        @Override
        public <T, J> T accept(CountryVisitor<T, J> visitor, J data) {
            return visitor.visitIndia(data);
        }
    },
    UNOTED_STATES {
        @Override
        public <T, J> T accept(CountryVisitor<T, J> visitor, J data) {
            return visitor.visitUnitedStates(data);
        }
    },
    BRAZIL {
        @Override
        public <T, J> T accept(CountryVisitor<T, J> visitor, J data) {
            return visitor.visitBrazil(data);
        }
    },
    MEXICO {
        @Override
        public <T, J> T accept(CountryVisitor<T, J> visitor, J data) {
            return visitor.visitMexico(data);
        }
    },
    GERMANY {
        @Override
        public <T, J> T accept(CountryVisitor<T, J> visitor, J data) {
            return visitor.visitGermany(data);
        }
    };

    public abstract <T, J> T accept(CountryVisitor<T, J> visitor, J data);

}
