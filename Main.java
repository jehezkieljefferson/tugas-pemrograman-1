import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    static String studentName = "Johan";
    static String studentId = "2116";
    static String BANNER = "BANNER";
    static Scanner in = new Scanner(System.in);
    static int currentQuestCount = 1;
    static int currentPengembaraCount = 1;
    static ArrayList<Quest> daftarQuest = new ArrayList<>();
    static ArrayList<Pengembara> daftarPengembara = new ArrayList<>();

    public static void main(String[] args){
        System.out.print(BANNER + '\n');
        System.out.print("Selamat datang di BurhanQuest!\n");
        System.out.printf(teksDibuatOleh() + "\n\n");

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
        }
        
        int desiredQuestCountInt = Integer.parseInt(desiredQuestCount);

        System.out.print("Mulai memasukkan data quest\n");
        while (desiredQuestCountInt-- > 0){
            try {
                System.out.printf("Quest %d\n", currentQuestCount);
                System.out.print(teksMasukanNamaQuest());
                String namaQuest = in.nextLine();
                System.out.print(teksMasukanDeskripsiQuest());
                String deskripsiQuest = in.nextLine();
                System.out.print(teksMasukanRewardQuest());
                String rewardQuest = in.nextLine();
                System.out.print(teksMasukanBonusExp());
                String bonusQuest = in.nextLine();
                System.out.print(teksMasukanTingkatKesulitan());
                String kesulitanQuest = in.nextLine();
                tambahQuest(namaQuest, deskripsiQuest, rewardQuest, bonusQuest, kesulitanQuest);
            } catch (DataInputMissmatchException e){
                System.out.print("Input tidak valid. Harap masukkan data dengan benar\n");
            } catch (IllegalArgumentException e){
                System.out.print("Input tidak valid. Harap masukkan data dengan benar\n");
            }
        }

        int desiredPengembaraCountInt = Integer.parseInt(desiredPengembaraCount);
        
        System.out.print("Mulai masukan data pengembara.\n");
        while (desiredPengembaraCountInt-- > 0){
            try {
                System.out.printf("Pengembara %d\n", currentPengembaraCount);
                System.out.print("Masukan nama pengembara: ");
                String namaPengembara = in.nextLine();
                System.out.print("Masukan level pengembara berupa bilangan bulat [1, 20]: ");
                String levelPengembara = in.nextLine();
                tambahPengembara(namaPengembara, levelPengembara);
                
            } catch (DataInputMissmatchException e) {
                System.out.print("Input tidak valid. Harap masukan data dengan benar\n");
            } catch (IllegalArgumentException e) {
                System.out.print("Input tidak valid. Harap masukkan data dengan benar\n");
            }
        }

        boolean runningMenu = true;
        while (runningMenu){
            String pilihanMenu = "0";
            try {
                System.out.print(teksMenu() + '\n');
                System.out.print("Masukan pilihan: ");
                pilihanMenu = in.nextLine();
                cekRangePositiveInteger(pilihanMenu, 1, 11);
                int pilihanMenuInt = Integer.parseInt(pilihanMenu);
                if (pilihanMenuInt == 1){
                    System.out.print(lihatDaftarQuest() + "\n\n");
                } else if (pilihanMenuInt == 2){
                    System.out.print(lihatDaftarPengembara() + "\n\n");
                } else if (pilihanMenuInt == 3){
                    System.out.print(teksMasukanNamaQuest());
                    String nama = in.nextLine(); cekX(nama);
                    System.out.print(teksMasukanDeskripsiQuest());
                    String deskripsi = in.nextLine(); cekX(deskripsi);
                    System.out.print(teksMasukanRewardQuest());
                    String reward = in.nextLine(); cekX(reward);
                    System.out.print(teksMasukanBonusExp());
                    String bonus = in.nextLine(); cekX(bonus);
                    System.out.print(teksMasukanTingkatKesulitan());
                    String kesulitan = in.nextLine(); cekX(kesulitan);
                    tambahQuest(nama, deskripsi, reward, bonus, kesulitan);
                    System.out.print("Quest berhasil ditambahkan.\n");
                } else if (pilihanMenuInt == 4){
                    System.out.print(teksMasukanNamaPengembara());
                    String nama = in.nextLine();
                    System.out.print(teksMasukanLevelPengembara());
                    String level = in.nextLine();
                    tambahPengembara(nama, level);
                } else if (pilihanMenuInt == 11){
                    runningMenu = false;
                }
            } catch (DataInputMissmatchException e) {
                System.out.print("Pilihan tidak valid. Harap masukkan pilihan dengan benar.\n");
            } catch (XException e){
            
            } catch (NullPointerException e) {
                System.out.print("Daftar kosong. \n");
            }
        }

        System.out.print("Terima kasih telah menggunakan BurhanQuest!\n");
        System.out.print(teksDibuatOleh() + "\n");
        System.out.print(BANNER + "\n\n");
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

    static void cekRangePositiveInteger(String data, int bawah, int atas) throws DataInputMissmatchException{
        cekPositiveInteger(data);
        int a = Integer.parseInt(data);
        if (a < bawah || a > atas) throw new DataInputMissmatchException();
    }

    static int hitungExpPengembara(String level) throws DataInputMissmatchException{
        if (!level.matches("\\d+")) throw new DataInputMissmatchException();
        return (int) (5000 * Math.pow(2, Double.parseDouble(level) - 2));
    }

    static String teksMenu(){
        return """
                1. Lihat daftar quest
                2. Lihat daftar pengembara
                3. Tambah quest
                4. Tambah pengembara
                5. Menjalankan quest
                6. Menyelesaikan quest
                7. Filter daftar quest
                8. Filter daftar pengembara
                9. Tampilkan daftar quest terurut
                10.Tampilkan daftar pengembara terurut
                11. Keluar
                """;
    }

    static String lihatDaftarQuest() throws NullPointerException{
        if (daftarQuest.size() < 1) throw new NullPointerException();
        String res = "";
        for (Quest q: daftarQuest){
            res += q.dataQuest() + "\n\n";
        }
        return res.trim();
    }

    static String lihatDaftarPengembara() throws NullPointerException{
        if (daftarPengembara.size() < 1) throw new NullPointerException();
        String res = "";
        for (Pengembara p: daftarPengembara){
            res += p.dataPengembara() + "\n\n";
        }
        return res.trim();
    }

    static String teksMasukanX(){
        return "(masukkan 'x' atau 'X' untuk kembali)";
    }
    static String teksMasukanNamaQuest(){
        return "Masukan nama quest" + teksMasukanX() + ": ";
    }

    static String teksMasukanDeskripsiQuest(){
        return "Masukan deskripsi quest" + teksMasukanX() + ": ";
    }

    static String teksMasukanRewardQuest(){
        return "Masukan reward quest" + teksMasukanX() + ": ";
    }

    static String teksMasukanBonusExp(){
        return "Masukan bonus exp berupa bilangan bulat" + teksMasukanX() + ": ";
    }

    static String teksMasukanTingkatKesulitan(){
        return "Masukan tingkat kesulitan quest (opsi: mudah, menengah, sulit)" + teksMasukanX() + ": ";
    }

    static void cekX(String data) throws XException{
        if (data.equalsIgnoreCase("x")) throw new XException();
    }

    static String teksMasukanNamaPengembara(){
        return "Masukan nama pengembara" + teksMasukanX() + ": ";
    }

    static String teksMasukanLevelPengembara(){
        return "Masukan level pengembara berupa bilangan bulat " + teksMasukanX() + ": ";
    }

    static void tambahQuest(String nama, String deskripsi, String reward, String bonusExp, String kesulitan) throws DataInputMissmatchException{
        cekAlphaAndSpacesString(nama);
        cekAlphaAndSpacesString(deskripsi);
        cekPositiveInteger(reward);
        cekPositiveInteger(bonusExp);
        cekTingkatKesulitan(kesulitan);
        int rewardInt = Integer.parseInt(reward);
        int bonusInt = Integer.parseInt(bonusExp);
        daftarQuest.add(new Quest(currentQuestCount, nama, deskripsi, rewardInt, bonusInt, kesulitan, "tersedia"));
        currentQuestCount++;
    }

    static void tambahPengembara(String nama, String level) throws DataInputMissmatchException{
        cekAlphaAndSpacesString(nama);
        cekPositiveInteger(level);
        cekRangePositiveInteger(level, 1, 20);
        int levelInt = Integer.parseInt(level);
        int expInt = hitungExpPengembara(level);
        daftarPengembara.add(new Pengembara(currentPengembaraCount, nama, levelInt, expInt, "kosong"));
        currentPengembaraCount++;
    }
}

