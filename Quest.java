public class Quest {
    String id;
    String name;
    String description;
    int reward;
    int bonusExp;
    String difficulty;
    int level;
    String status;

    public Quest(int id ,String name, String description, int reward, int bonusExp, String difficulty, String status){
        this.id = "Q" + id;
        this.name = name;
        this.description = description;
        this.reward = reward;
        this.bonusExp = bonusExp;
        this.difficulty = difficulty;
        this.status = status;
    }

    String dataQuest(){
        String data = "";
        data += String.format("ID Quest: %s\n", this.id);
        data += String.format("Nama Quest: %s\n", this.name);
        data += String.format("Deskripsi Quest: %s\n", this.description);
        data += String.format("Reward Quest: %d koin\n", this.reward);
        data += String.format("Bonus Exp Quest: %d poin exp\n", this.bonusExp);
        data += String.format("Tingkat Kesulitan Quest: %s\n", getSimbolKesulitan(this.difficulty));
        data += String.format("Status Quest: %s", this.status);
        return data;
    }

    String getSimbolKesulitan(String kesulitan){
        if (kesulitan.equalsIgnoreCase("mudah")) return "*";
        else if (kesulitan.equalsIgnoreCase("menengah")) return "**";
        else return "***";
    }


}
