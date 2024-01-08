public class Student {
        private String name;
        private String rollNo;
        private String className;

        public Student(String name, String rollNo, String className) {
            this.name = name;
            this.rollNo = rollNo;
            this.className = className;
        }

        public String getRollNo() {
        return rollNo;
    
        }
    
        public String getName() {
        return name;
   
        }
 
        public String getClassName() {
        return className;
   
        }
   
        public void setName(String name) {
        this.name = name;
  
        }
   
        public void setClassName(String className) {
        this.className = className;
    }
        public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
    