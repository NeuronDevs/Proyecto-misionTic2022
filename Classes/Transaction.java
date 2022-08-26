package Classes;

public class Transaction {

        private  long id;
        private  String concept;
        private float amount;
        private User user;
        private Enterprise  enterprise;
        private date createAt;
        private date updateAt;

    public Transaction( ) {

    }

    public Transaction(long id, String concept, float amount, User user, Enterprise enterprise, date createAt, date updateAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.enterprise = enterprise;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getConcept() {
            return concept;
        }

        public void setConcept(String concept) {
            this.concept = concept;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Enterprise getEnterprise() {
            return enterprise;
        }

        public void setEnterprise(Enterprise enterprise) {
            this.enterprise = enterprise;
        }

        public date getCreateAt() {
            return createAt;
        }

        public void setCreateAt(date createAt) {
            this.createAt = createAt;
        }

        public date getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(date updateAt) {
            this.updateAt = updateAt;
        }

    }
