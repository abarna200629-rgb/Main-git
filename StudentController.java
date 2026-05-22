class StudentController {

    Student[] students;
    int count;

    StudentController(int size) {
        students = new Student[size];
        count = 0;
    }

    void addStudent(int id, String name, int mark) {
        students[count++] = new Student(id, name, mark);
    }

    Student[] getStudents() {
        return students;
    }

    int getCount() {
        return count;
    }

    Student searchStudent(String name) {

        for (int i = 0; i < count; i++) {

            if (students[i].name.equalsIgnoreCase(name)) {
                return students[i];
            }
        }

        return null;
    }

    String updateMark(String name, int newMark) {

        Student s = searchStudent(name);

        if (s != null) {
            s.mark = newMark;
            return "Mark Updated Successfully";
        }

        return "Student Not Found";
    }

    String deleteStudent(String name) {

        for (int i = 0; i < count; i++) {

            if (students[i].name.equalsIgnoreCase(name)) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                count--;
                return "Student Deleted Successfully";
            }
        }

        return "Student Not Found";
    }
}