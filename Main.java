import java.util.Scanner;

public class Main{
    static String studentName = "Johan";
    static String studentId = "2116";
    static String BANNER = "BANNER";
    static Scanner in = new Scanner(System.in);
    static int currentQuestCount = 1;
    static int pengembaraCount = 1;
    public static void main(String[] args){
        System.out.print(BANNER + '\n');
        System.out.print("Selamat datang di BurhanQuest!\n");
        System.out.printf(teksDibuatOleh() + "\n\n");
        
        System.out.print("Terima kasih telah menggunakan BurhanQuest!\n");
        System.out.print(teksDibuatOleh() + "\n");
        System.out.print(BANNER + "\n\n");

        System.out.print("Selamat datang di BurhanQuest\n");

        boolean masukanJumlahData = true;
        String desiredPengembaraCount = "0";
        String desiredQuestCount = "0";
        while (masukanJumlahData){
            try {
                System.out.print("Silakan masukan banyak quest yang ingin didaftarkan: ");
                desiredQuestCount= in.nextLine();
                cekPositiveInteger(desiredQuestCount);
                System.out.print("Silakan masukan banyak pengembara yang ingin didaftarkan: ");
                desiredPengembaraCount = in.nextLine();
                cekPositiveInteger(desiredPengembaraCount);
                masukanJumlahData = false;
            } catch (IllegalArgumentException e){
                System.out.print("Input tidak valid. Harap mamsukan bilangan bulat nonnegatif\n");
            } 
        
        boolean masukanDataQuest = Integer.parseInt(desiredQuestCount) > 0;
        while (masukanDataQuest){
            try {
                System.out.print("Mulai memasukkan data quest\n");
                System.out.printf("Quest %d\n", currentQuestCount);
                System.out.print("Masukan nama quest: ");
                String namaQuest = in.nextLine();
                System.out.print("Masukan deskripsi quest: ");
                String deskripsiQuest = in.nextLine();
                System.out.print("Masukan reward quest berupa bilangan bulat nonnegatif: ");
                String rewardQuest = in.nextLine();
                System.out.print("Masukan bonus exp quest berupa bilangan bulat nonnegatif: ");
                String bonusQuest = in.nextLine();
                System.out.print("Masukan tingkat kesulitan quest (opsi: mudah, menengah, sulit): ");
                String kesulitanQuest = in.nextLine();
                cekAlphaAndSpacesString(namaQuest);
                cekAlphaAndSpacesString(deskripsiQuest);
                cekPositiveInteger(rewardQuest);
                cekPositiveInteger(bonusQuest);
                cekTingkatKesulitan(kesulitanQuest);
                masukanDataQuest = false;
            } catch (DataInputMissmatchException e){
                System.out.print("Input tidak valid. Harap masukkan data dengan benar\n");
            }
        }

        boolean masukanDataPengembara = Integer.parseInt(desiredPengembaraCount) > 0;
        while (masukanDataPengembara){
            try {
                System.out.print("Mulai masukan data pengembara.\n");
                System.out.printf("Pengembara %d\n", pengembaraCount);
                System.out.print("Masukan nama pengembara: ");
                String namaPengembara = in.nextLine();
                System.out.print("Masukan level pengembara berupa bilangan bulat [1, 20]: ");
                String levelPengembara = in.nextLine();
                cekAlphaAndSpacesString(namaPengembara);
                cekLevelPengembara(levelPengembara);
                int expPengembara = hitungExpPengembara(levelPengembara);
                
            } catch (DataInputMissmatchException e) {
                System.out.print("Input tidak valid. Harap masukan data dengan benar\n");
            }
        }
    }
        
    
    }

    static String teksDibuatOleh(){
        return String.format("Dibuat oleh: %s - %s", studentName, studentId);
    }

    //cek validitas jumlah pengembara dan jumlah quest sub task 2
    //return data dalam bentuk int jika memenuhi syarat 
    static void cekPositiveInteger(String data) throws IllegalArgumentException{
        if (!data.matches("\\d+")) throw new IllegalArgumentException();
        int dataInt = Integer.parseInt(data);
        if (dataInt < 0) throw new IllegalArgumentException();
    }

    static void cekAlphaAndSpacesString(String data) throws DataInputMissmatchException{
        if (!data.matches("[a-zA-Z0-9 ]+")) throw new DataInputMissmatchException();
    }

    static void cekTingkatKesulitan(String data) throws DataInputMissmatchException{
        if (!(data.equalsIgnoreCase("mudah") ||
            data.equalsIgnoreCase("menengah") ||
            data.equalsIgnoreCase("sulit"))) throw new DataInputMissmatchException();
    }

    static void cekLevelPengembara(String data) throws DataInputMissmatchException{
        cekPositiveInteger(data);
        int a = Integer.parseInt(data);
        if (a < 1 || a > 20) throw new DataInputMissmatchException();
    }

    static int hitungExpPengembara(String level) throws DataInputMissmatchException{
        if (!level.matches("\\d+")) throw new DataInputMissmatchException();
        return (int) (5000 * Math.pow(2, Double.parseDouble(level) - 2));
    }

    
}