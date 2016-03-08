package task1;

public class Text extends File {


    public Text(String name) {
        super(name, "Text");
    }

    @Override
    public String getType() {
        return "Text";
    }
}
