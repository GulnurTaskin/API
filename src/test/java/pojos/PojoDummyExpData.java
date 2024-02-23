package pojos;

public class PojoDummyExpData {

    private String status;

    private PojoHerOkuAppExpBody data;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PojoHerOkuAppExpBody getData() {
        return data;
    }

    public void setData(PojoHerOkuAppExpBody data) {
        this.data = data;
    }

    public PojoDummyExpData(String status, String message, PojoHerOkuAppExpBody data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public PojoDummyExpData(String success, PojoDummyData dataPOJO, String s) {
    }

    @Override
    public String toString() {
        return "PojoDummyExpData{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
