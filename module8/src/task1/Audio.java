package task1;


public class Audio extends File {


    public Audio(String name) {
        super(name, "Audio");
    }

    @Override
   public String getType() {
        return "Audio";
    }
}
