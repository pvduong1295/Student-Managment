import java.text.DecimalFormat;

public abstract class Course_Result {
    private String Course_ID;
    private String Course_Name;
    private double FE;
    private double FR;
    
    public Course_Result(){
        Course_ID ="PRO192";
        Course_Name="PRO192";
        FE = 0.0;
        FR = 0.0;
    }

    public Course_Result(String Course_ID, String Course_Name, double FE, double FR) {
        this.Course_ID = Course_ID;
        this.Course_Name = Course_Name;
        this.FE = FE;
        this.FR = FR;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String Course_ID) {
        this.Course_ID = Course_ID;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String Course_Name) {
        this.Course_Name = Course_Name;
    }

    public double getFE() {
        return FE;
    }

    public void setFE(double FE) {
        this.FE = FE;
    }

    public double getFR() {
        return FR;
    }

    public void setFR(double FR) {
        this.FR = FR;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.#");
        return "Course_ID=" + Course_ID + ", Course_Name=" + Course_Name + ", FE=" + FE + ", FR=" + df.format(FR) ;
    }
    
    public abstract boolean getResult();    
    public abstract double getAvgMark();

    
}
