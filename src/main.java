
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<PRO192_Result> arrPro192 = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.println("QUẢN LÝ SINH VIÊN");
        int k = 9;
        while (k != 0) {
            System.out.println("MENU");
            System.out.println("1.Tạo 10 sinh viên ngẫu nhiên.");
            System.out.println("2.Danh sách sinh viên.");
            System.out.println("3.Tìm sinh viên.");
            System.out.println("4.Sửa thông tin sinh viên.");
            System.out.println("5.Thêm sinh viên.");
            System.out.println("6.Xóa sinh viên.");
            System.out.println("0.Thoát chương trình.");
            System.out.println("..........");
            k = sc.nextInt();
            if (k == 1) {
                autoGenerate10Student(arrPro192);
            } else if (k == 2) {
                showList(arrPro192);
            } else if (k == 3) {
                searchStudent(arrPro192);
            } else if (k == 4) {
                editList(arrPro192);
            } else if (k == 5) {
                addStudent(arrPro192);
            } else if (k == 6) {
                deleteStudent(arrPro192);
            } else if (k == 0) {
                System.out.println("TẠM BIỆT!");
                System.exit(0);
            } else {
                System.out.println("HÃY CHỌN TỪ 0 ĐẾN 6!");
            }
            System.out.println("=========================================");
        }
    }

    public static void autoGenerate10Student(ArrayList<PRO192_Result> arrPro) {
        for (int i = 0; i < 10; i++) {
            PRO192_Result new_Stud = new PRO192_Result();
            new_Stud.setStudentID(random_String());
            new_Stud.setStudentName(generateName());
            new_Stud.setWorkshop1(random_Number());
            new_Stud.setWorkshop2(random_Number());
            new_Stud.setWorkshop3(random_Number());
            new_Stud.setWorkshop4(random_Number());
            new_Stud.setWorkshop5(random_Number());
            new_Stud.setProjectAssignment(random_Number());
            new_Stud.setPE(random_Number());
            new_Stud.setFE(random_Number());
            arrPro.add(new_Stud);
        }
        System.out.println("Đã tạo xong!");
    }

    public static void showList(ArrayList<PRO192_Result> arrPro) {
        Collections.sort(arrPro,new Sort_By_AvgMark_Ascending());
        for (PRO192_Result i : arrPro) {
            System.out.println(i);
        }
        System.out.println("=========================================");
    }

    public static void editList(ArrayList<PRO192_Result> arrPro) {
        ArrayList<Integer> searched_Stud = new ArrayList();
        int k = 10;
        while (k != 0) {
            searched_Stud.clear();
            searched_Stud.addAll(searchStudent(arrPro));
            if (searched_Stud.size() == 1) {
                edit(arrPro, searched_Stud.get(0));
                k = 0;
            } else if (searched_Stud.isEmpty()) {
                System.out.println("Không có ai !");
                k = 0;
            } else {
                System.out.println("NÊN TÌM LẠI THEO ID!");
            }
            System.out.println("=========================================");
        }
    }

    public static void edit(ArrayList<PRO192_Result> arrPro, int pos) {
        Scanner sc_Int = new Scanner(System.in);
        Scanner sc_Str = new Scanner(System.in);
        Scanner sc_Double = new Scanner(System.in);
        System.out.println("BẠN MUỐN SỬA GÌ? :");
        System.out.println("1.Workshop 1 ");
        System.out.println("2.Workshop 2 ");
        System.out.println("3.Workshop 3 ");
        System.out.println("4.Workshop 4 ");
        System.out.println("5.Workshop 5 ");
        System.out.println("6.ProjectAssignment");
        System.out.println("7.Practical Exam");
        System.out.println("8.Final Exam");
        System.out.println("9.Tên");
        System.out.println("0.Trở lại Menu!");
        int k = 10;
        while (k != 0) {
            k = sc_Int.nextInt();
            if (k == 1) {
                double W1 = sc_Double.nextDouble();
                arrPro.get(pos).setWorkshop1(W1);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 2) {
                double W2 = sc_Double.nextDouble();
                arrPro.get(pos).setWorkshop2(W2);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 3) {
                double W3 = sc_Double.nextDouble();
                arrPro.get(pos).setWorkshop3(W3);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 4) {
                double W4 = sc_Double.nextDouble();
                arrPro.get(pos).setWorkshop1(W4);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 5) {
                double W5 = sc_Double.nextDouble();
                arrPro.get(pos).setWorkshop5(W5);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 6) {
                double AS = sc_Double.nextDouble();
                arrPro.get(pos).setProjectAssignment(AS);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 7) {
                double PE = sc_Double.nextDouble();
                arrPro.get(pos).setProjectAssignment(PE);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 8) {
                double FE = sc_Double.nextDouble();
                arrPro.get(pos).setProjectAssignment(FE);
                System.out.println("Đã sửa!");
                k = 0;
            } else if (k == 9) {
                String re_name = sc_Str.nextLine();
                arrPro.get(pos).setStudentName(re_name);
                System.out.println("Đã sửa!");
                k = 0;
            } else {
                System.out.println("HÃY CHỌN TỪ 0 ĐẾN 9!");
            }
            System.out.println("=========================================");
        }

    }

    public static ArrayList<Integer> searchStudent(ArrayList<PRO192_Result> arrPro) {//Tìm học sinh theo tên hoặc ID
        Scanner sc = new Scanner(System.in);
        Scanner sc_Str = new Scanner(System.in);
        ArrayList<Integer> pos = new ArrayList();
        int k = 10;
        while (k != 0) {
            System.out.println("TÌM NGƯỜI BẠN MUỐN.");
            System.out.println("TÌM THEO :");
            System.out.println("1.Tên");
            System.out.println("2.StudentID");
            System.out.println("0.Trở lại Menu");
            k = sc.nextInt();
            if (k == 1) {
                System.out.println("Nhập tên :");
                String stud_name;
                int count_na = 0;
                stud_name = sc_Str.nextLine();
                for (int i = 0; i < arrPro.size(); i++) {
                    if (stud_name.toUpperCase().compareTo(arrPro.get(i).getStudentName().toUpperCase()) == 0) {
                        System.out.println(arrPro.get(i));
                        pos.add(i);
                        count_na++;
                    }
                }
                if (count_na == 0) {
                    System.out.println("KHÔNG CÓ AI!");
                }
            } else if (k == 2) {

                int count_id = 0;
                System.out.println("NHẬP ID:");
                String studentid = sc_Str.nextLine();
                for (int i = 0; i < arrPro.size(); i++) {
                    if (studentid.toUpperCase().compareTo(arrPro.get(i).getStudentID().toUpperCase()) == 0) {
                        System.out.println(arrPro.get(i));
                        pos.add(i);
                        count_id++;
                    }
                }
                if (count_id == 0) {
                    System.out.println("KHÔNG CÓ AI!");
                }
            } else if (k != 0) {
                System.out.println("HÃY CHỌN OPTION 1, 2 HOẶC 0!");
            }
            System.out.println("=========================================");
        }
        return pos;
    }

    public static void addStudent(ArrayList<PRO192_Result> arrPro) {// thêm sinh viên
        //kết hợp với function searchStudent 
        Scanner sc = new Scanner(System.in);
        PRO192_Result new_Stud = new PRO192_Result();
        System.out.println("Họ và tên:");
        String name = sc.nextLine();
        int count = 0;
        while (count == 0) {
            System.out.println("StudentID :");
            String studentid = sc.nextLine();
            int check = 0;
            for (int i = 0; i < arrPro.size(); i++) {
                if (studentid.compareTo(arrPro.get(i).getStudentID()) == 0) {
                    check++;
                }
            }
            if (check != 0) {
                System.out.println("StudentID đã bị trùng.");
            } else {
                new_Stud.setStudentName(name);
                new_Stud.setStudentID(studentid);
                arrPro.add(new_Stud);
                count++;
                System.out.println("Đã thêm!");
            }
            System.out.println("=========================================");
        }

    }

    private static void deleteStudent(ArrayList<PRO192_Result> arrPro) {// hàm xóa sinh viên
        ArrayList<Integer> searched_Stud = new ArrayList();
        int k = 0;
        while (k == 0) {
            searched_Stud.clear();
            searched_Stud.addAll(searchStudent(arrPro));
            if (searched_Stud.size() == 1) {
                arrPro.remove(arrPro.get(searched_Stud.get(0)));
                k = 1;
            } else if (searched_Stud.size() == 0) {
                System.out.println("Không có ai !");
                k = 1;
            } else {
                System.out.println("NÊN TÌM LẠI THEO ID!");
            }
        }
        System.out.println("Đã xóa!");
    }

    //Tất cả liên quan đến random 
    public static double random_Number() {
        Random rand = new Random();
        double a = (Math.round(rand.nextFloat() * 10));
        return Math.round(rand.nextFloat() * 9) + a / 10.0;
    }

    public static String random_String() {
        String Norm = "1234567890";
        StringBuilder text = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int index = (int) (rand.nextFloat() * Norm.length());
            text.append(Norm.charAt(index));
        }
        String new_text = text.toString();
        return "HE15" + new_text;
    }

    public static String generateName() {// Em để ít lựa chọn tên để tạo được tên trùng lặp . Để có thể kiểm tra được các trường hợp trùng tên.
        String dev_name = "";
        Random rand = new Random();
        String[] Gender = {"Boy", "Girl"};
        String[] Name_Male = {"Duong", "Ngoc"};
        String[] Name_Female = {"Giang", "Tram"};
        String[] Midle_Name_Female = {"Thi", "Ngoc"};
        String[] Midle_Name_Male = {"Viet", "Van"};
        String[] Family_Name = {"Pham"};
        if (Gender[rand.nextInt(2)] == "Boy") {
            dev_name = Family_Name[rand.nextInt(Family_Name.length)] + " " + Midle_Name_Male[rand.nextInt(Midle_Name_Male.length)] + " " + Name_Male[rand.nextInt(Name_Male.length)];
        } else {
            dev_name = Family_Name[rand.nextInt(Family_Name.length)] + " " + Midle_Name_Female[rand.nextInt(Midle_Name_Female.length)] + " " + Name_Female[rand.nextInt(Name_Female.length)];
        }
        return dev_name;
    }

}

class Sort_By_Name_Ascending implements Comparator<PRO192_Result>{

    @Override
    public int compare(PRO192_Result o1, PRO192_Result o2) {
        return o1.getStudentName().compareTo(o2.getStudentName());
    }
    
}

class Sort_By_Name_Descending implements Comparator<PRO192_Result>{

    @Override
    public int compare(PRO192_Result o1, PRO192_Result o2) {
        return o2.getStudentName().compareTo(o1.getStudentName());
    }
    
}

class Sort_By_ID_Ascending implements Comparator<PRO192_Result>{

    @Override
    public int compare(PRO192_Result o1, PRO192_Result o2) {
        return o1.getStudentID().compareTo(o2.getStudentID());
    }
    
}

class Sort_By_ID_Descending implements Comparator<PRO192_Result>{

    @Override
    public int compare(PRO192_Result o1, PRO192_Result o2) {
        return o2.getStudentID().compareTo(o1.getStudentID());
    }
    
}

class Sort_By_AvgMark_Ascending implements Comparator<PRO192_Result>{

    @Override
    public int compare(PRO192_Result o1, PRO192_Result o2) {
        if (o1.getAvgMark() > o2.getAvgMark()) {
            return 1;
        } else if (o1.getAvgMark() < o2.getAvgMark()) {
            return -1;
        } else {
            return 0;
        }
    }
    
}