public class Pengembara {
    String id;
    String name;
    int level;
    int exp;
    String status;
    public Pengembara(int id, String name, int level, int exp, String status){
        this.id = "P" + id;
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.status = status;
    }

    String dataPengembara(){
        String data = "";
        data += String.format("ID Pengembara: %s\n", this.id);
        data += String.format("Nama Pengembara: %s\n", this.name);
        data += String.format("Level Pengembara: %d\n", this.level);
        data += String.format("Exp Pengembara: %d poin exp\n", this.exp);
        data += String.format("Status Pengembara: %s", this.status);
        return data;
    }
}
