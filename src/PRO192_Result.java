import java.text.DecimalFormat;

public class PRO192_Result extends Course_Result  {

    private String StudentID;
    private String StudentName;
    private double Workshop1;
    private double Workshop2;
    private double Workshop3;
    private double Workshop4;
    private double Workshop5;
    private double ProjectAssignment;
    private double PE;
    private int sorting_option;
    private int sorting_order;

    public PRO192_Result() {
        super();
        Workshop1 = 0.0;
        Workshop2 = 0.0;
        Workshop3 = 0.0;
        Workshop4 = 0.0;
        Workshop5 = 0.0;
        ProjectAssignment = 0.0;
        PE = 0.0;
    }

    public PRO192_Result(String StudentID, String StudentName, double Workshop1, double Workshop2, double Workshop3, double Workshop4, double Workshop5, double ProjectAssignment, double PE) {
        super();
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.Workshop1 = Workshop1;
        this.Workshop2 = Workshop2;
        this.Workshop3 = Workshop3;
        this.Workshop4 = Workshop4;
        this.Workshop5 = Workshop5;
        this.ProjectAssignment = ProjectAssignment;
        this.PE = PE;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public double getWorkshop1() {
        return Workshop1;
    }

    public void setWorkshop1(double Workshop1) {
        this.Workshop1 = Workshop1;
    }

    public double getWorkshop2() {
        return Workshop2;
    }

    public void setWorkshop2(double Workshop2) {
        this.Workshop2 = Workshop2;
    }

    public double getWorkshop3() {
        return Workshop3;
    }

    public void setWorkshop3(double Workshop3) {
        this.Workshop3 = Workshop3;
    }

    public double getWorkshop4() {
        return Workshop4;
    }

    public void setWorkshop4(double Workshop4) {
        this.Workshop4 = Workshop4;
    }

    public double getWorkshop5() {
        return Workshop5;
    }

    public void setWorkshop5(double Workshop5) {
        this.Workshop5 = Workshop5;
    }

    public double getProjectAssignment() {
        return ProjectAssignment;
    }

    public void setProjectAssignment(double ProjectAssignment) {
        this.ProjectAssignment = ProjectAssignment;
    }


    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("###.#");
        if (getResult() == true) {
            return "StudentID=" + StudentID + ", StudentName=" + StudentName + ", Workshop1=" + Workshop1 + ", Workshop2=" + Workshop2 + ", Workshop3=" + Workshop3 + ", Workshop4=" + Workshop4 + ", Workshop5=" + Workshop5 + ", ProjectAssignment=" + ProjectAssignment + ", PE=" + getPE() + ", FE=" + getFE() + ", AvgMark=" + df.format(getAvgMark()) + ", PASSED";
        } else {
            return "StudentID=" + StudentID + ", StudentName=" + StudentName + ", Workshop1=" + Workshop1 + ", Workshop2=" + Workshop2 + ", Workshop3=" + Workshop3 + ", Workshop4=" + Workshop4 + ", Workshop5=" + Workshop5 + ", ProjectAssignment=" + ProjectAssignment + ", PE=" + getPE() + ", FE=" + getFE() + ", AvgMark=" + df.format(getAvgMark()) + ", NOT PASSED";
        }
    }

    public double getPE() {
        return PE;
    }

    public void setPE(double PE) {
        this.PE = PE;
    }

    @Override
    public boolean getResult() {
        super.setFR(getAvgMark());
        if (getFE() >= 4.0 && getFR() >= 5.0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getAvgMark() {
        double AvgMark = (getWorkshop1() + getWorkshop2() + getWorkshop3() + getWorkshop4() + getWorkshop5()) * 0.04 + getProjectAssignment() * 0.2 + getPE() * 0.3 + super.getFE() * 0.3;
        super.setFR(AvgMark);
        return AvgMark;
    }
 
}
