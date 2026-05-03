public class Main{
    static String studentName = "Johan";
    static String studentId = "2116";
    static String BANNER = "BANNER";
    public static void main(String[] args){
        System.out.print(BANNER + '\n');
        System.out.print("Selamat datang di BurhanQuest!\n");
        System.out.printf(teksDibuatOleh() + '\n');
        
        System.out.print("Terima kasih telah menggunakan BurhanQuest!\n");
        System.out.print(teksDibuatOleh() + '\n');
        System.out.print(BANNER + '\n');
    
    }

    static String teksDibuatOleh(){
        return String.format("Dibuat oleh: %s - %s", studentName, studentId);
    }
}