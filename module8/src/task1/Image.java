package task1;


public class Image extends File{

    public Image(String name) {
        super(name, "Image");
    }

    @Override
    public String getType() {
        return "Image";
    }

}
