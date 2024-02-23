package pojos;

public class PojoHerOkuAppReqBody {

    /*   {
                    "firstname" : "Ahmet",
                    "lastname" : "Bulut",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                             "checkin" : "2021-06-01",
                             "checkout" : "2021-06-10"
                                      },
                    "additionalneeds" : "wi-fi"
                }                                                 */

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private PojoHerOkuAppBookingdates bookingdates;
    private String additonalneeds;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHerOkuAppBookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHerOkuAppBookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditonalneeds() {
        return additonalneeds;
    }

    public void setAdditonalneeds(String additonalneeds) {
        this.additonalneeds = additonalneeds;
    }

    public PojoHerOkuAppReqBody(String firstname, String lastname, int totalprice, boolean depositpaid, PojoHerOkuAppBookingdates bookingdates, String additonalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additonalneeds = additonalneeds;
    }

    public PojoHerOkuAppReqBody() {
    }

    @Override
    public String toString() {
        return "PojoHerOkuAppReqBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additonalneeds='" + additonalneeds + '\'' +
                '}';
    }
}
